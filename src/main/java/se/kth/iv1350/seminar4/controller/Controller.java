package se.kth.iv1350.seminar4.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.seminar4.Integration.AccountingSystem;
import se.kth.iv1350.seminar4.Integration.InvalidItemIdException;
import se.kth.iv1350.seminar4.Integration.InventorySystem;
import se.kth.iv1350.seminar4.Integration.InventorySystemException;
import se.kth.iv1350.seminar4.Integration.ItemDTO;
import se.kth.iv1350.seminar4.Integration.Printer;
import se.kth.iv1350.seminar4.Integration.StoreDTO;
import se.kth.iv1350.seminar4.Integration.SystemCreator;
import se.kth.iv1350.seminar4.Integration.TotalRevenueFileOutput;
import se.kth.iv1350.seminar4.controller.DatabaseFailedException;
import se.kth.iv1350.seminar4.model.CashRegister;
import se.kth.iv1350.seminar4.model.DisplayInfoDTO;
import se.kth.iv1350.seminar4.model.Payment;
import se.kth.iv1350.seminar4.model.PaymentObserver;
import se.kth.iv1350.seminar4.model.Sale;
import se.kth.iv1350.seminar4.model.SaleLog;
import se.kth.iv1350.seminar4.util.Amount;
import se.kth.iv1350.seminar4.util.ErrorLogger;

/**
 *
 * This is the application's only controller where all calls to the model is passed through.
 */
public class Controller {
    private StoreDTO store;
    private CashRegister cashRegister;
    private SaleLog saleLog;
    private Sale sale;
    private InventorySystem invSys;
    private AccountingSystem accSys;
    private Printer printer;
    private List<PaymentObserver> paymentObservers = new ArrayList();
    private ErrorLogger errorLogger;

    /**
     * Creates a new instance of the <code>Controller</code> class.
     *
     * @param creator Handles creation of external systems, like accounting or inventory
     */
    public Controller(SystemCreator creator){
        store = new StoreDTO();
        cashRegister = new CashRegister(new Amount(1000.0));
        saleLog = new SaleLog();
        invSys = creator.getInventorySystem();
        accSys = creator.getAccountingSystem();
        printer = creator.getPrinter();
        errorLogger = new ErrorLogger();
        paymentObservers.add(new TotalRevenueFileOutput());
    }

    /**
     * Initiates a new sale. Must be called before any other actions in a sale can be taken.
     */
    public void startSale(){
        sale = new Sale(store);
    }

    /**
     * Adds a new item to the current sale.
     *
     * @param itemID The ID of the item being added to the sale
     * @return Returns the info from the updated sale to be displayed in the view.
     * @throws InvalidItemIdException If the itemID does not exist in the <code>InventorySystem</code>.
     * @throws OperationFailedException If the operation can not be completed for some other reason than
     * the itemID not existing in the <code>InventorySystem</code>.
     */
    public DisplayInfoDTO scanItem(int itemID) throws DatabaseFailedException, InvalidItemIdException {
        try{
            ItemDTO scannedItem = invSys.fetchItem(itemID);
            DisplayInfoDTO currentSaleInfo = sale.updateSale(scannedItem);
            return currentSaleInfo;
        }
        catch(InventorySystemException e){
            errorLogger.logException(e);
            throw new DatabaseFailedException("Item could not be scanned.", e);
        }
    }

    /**
     * Ends the ongoing sale and returns the price of the sale.
     *
     * @return The runningTotal from the ongoing sale at the end of it.
     */
    public Amount endSale(){
        return sale.endSale();
    }

    /**
     * Concludes the sale by entering a payment and returning an amount of change.
     * Updates the balance in the cash register. Handles reporting of the sale to the
     * <code>SaleLog</code> and external systems.
     *
     * @param paidAmount The amount paid by the customer.
     * @return The amount of change the customer shall receive after payment.
     */
    public Amount pay(Amount paidAmount){
        Payment payment = new Payment(paidAmount, sale.getRunningTotal());
        sale.setPayment(payment);
        payment.addPaymentObservers(paymentObservers);
        Amount change = payment.calculateChange();
        cashRegister.updateBalance(paidAmount, change);
        sale.printReceipt(printer);
        reportSale(sale);
        return change;
    }

    private void reportSale(Sale sale){
        accSys.updateSystem(sale);
        invSys.updateSystem(sale);
        saleLog.logSale(sale);
    }
    
    /**
     * When a payment have been made, the specified observer will be notified of the sale that has been paid for.
     * Notifications will only be there after this method is called.
     *
     * @param paymentObserver Is the observer to notify.
     */
    
    public void addPaymentObserver(PaymentObserver paymentObserver){
        paymentObservers.add(paymentObserver);
    }

}