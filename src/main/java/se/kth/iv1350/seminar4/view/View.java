package se.kth.iv1350.seminar4.view;


import se.kth.iv1350.seminar4.Integration.InvalidItemIdException;
import se.kth.iv1350.seminar4.controller.Controller;
import se.kth.iv1350.seminar4.controller.DatabaseFailedException;
import se.kth.iv1350.seminar4.model.DisplayInfoDTO;
import se.kth.iv1350.seminar4.util.Amount;
import se.kth.iv1350.seminar4.util.ErrorLogger;

/**
 * This is a placeholder for the real view. It contains hardcoded executions with calls to all system operations in the
 * controller.
 */
public class View {
    private Controller contr;
    private ErrorLogger errorLogger;
    private ErrorMessageHandler errorMessageHandler;

    /**
     * Creates a new instance using the specified controller to make calls to all other layers.
     *
     * @param contr The specified controller.
     */
    public View(Controller contr){
        this.contr = contr;
        contr.addPaymentObserver(new TotalRevenueView());
        errorLogger = new ErrorLogger();
        errorMessageHandler = new ErrorMessageHandler();
    }

    private void scanItemExecution(int itemID){
        try{
            DisplayInfoDTO displayInfo = contr.scanItem(itemID);
            System.out.println("\nItem name: " + displayInfo.getItem().getDescription());
            System.out.println("Price of item (without VAT): " + displayInfo.getItem().getPrice());
            System.out.println("Running total (with VAT): " + displayInfo.getRunningTotal() + "\n");
        }
        catch(InvalidItemIdException e){
            errorMessageHandler.showErrorMessage(
                    "Item with entered ID (" +
                    e.getInvalidItemID() +
                    ") not found in inventory system"
            );
        }
        catch(DatabaseFailedException e){
            errorMessageHandler.showErrorMessage(
                    "Unable to scan item, try again."
            );
        }
    }
    /**
     * An execution of the program containing calls to all system operations in the controller.
     * Displays what would be displayed in the view in system.out
     */
    public void fakeExecution(){
        try {
            contr.startSale();
            System.out.println("A new sale has been initialized.");
            System.out.println("Adding several items to the sale.");
            scanItemExecution(9999);
            scanItemExecution(300);
            scanItemExecution(313);
            scanItemExecution(315);
            Amount totalPrice = contr.endSale();
            System.out.println("Sale ended. \n" +
                    "Total price of sale (with VAT): " + totalPrice);
            Amount change = contr.pay(new Amount(totalPrice.getAmount() + 5));
            System.out.println("Sale has been paid for. \n" +
                    "Amount of change: " + change);
            contr.startSale();
            System.out.println("\nA second sale has been initialized.");
            System.out.println("Adding several items to the sale.");
            scanItemExecution(303);
            scanItemExecution(9999);
            scanItemExecution(367);
            scanItemExecution(313);
            totalPrice = contr.endSale();
            System.out.println("Sale ended. \n" +
                    "Total price of sale (with VAT): " + totalPrice);
            change = contr.pay(new Amount(totalPrice.getAmount() + 10));
            System.out.println("Sale has been paid for. \n" +
                    "Amount of change: " + change);
        }
        catch(Exception e){
            errorLogger.logException(e);
            errorMessageHandler.showErrorMessage("Unexpected error, restart program.");
        }
    }
}