package se.kth.iv1350.seminar4.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.seminar4.Integration.ItemDTO;
import se.kth.iv1350.seminar4.Integration.Printer;
import se.kth.iv1350.seminar4.Integration.StoreDTO;
import se.kth.iv1350.seminar4.util.Amount;



public class Sale {
    private Receipt receipt;
    private LocalDate dateOfSale;
    private LocalTime timeOfSale;
    private Amount runningTotal;
    private Amount totalVAT;
    private Payment payment;
    private List<ItemInSale> itemsToPurchase = new ArrayList<>();
    
    
    /**
     * Creates a new sale instance.
     *
     * @param store The store in which the sale is taking place.
     */
    public Sale(StoreDTO store){
        receipt = new Receipt(store, this);
        runningTotal = new Amount(0.0);
        totalVAT = new Amount(0.0);
    }

    /**
     * Updates the sale when an item is scanned.
     * If the item is null, nothing is added.
     * If the item exists in the sale, the quantity of it is increased.
     * If the item does not exist in the sale, it is added.
     *
     * @param item The <code>ItemDTO</code> being scanned.
     * @return The display info to be displayed in the view.
     */
    public DisplayInfoDTO updateSale(ItemDTO item){
        if(isItemRegistered(item)){
            addRegisteredItemToSale(item);
        }
        else{
            addNewItemToSale(item);
        }
        DisplayInfoDTO displayInfo = new DisplayInfoDTO(item, runningTotal);
        return displayInfo;
    }

    /**
     * Checks if a certain <code>ItemDTO</code> already exists in the sale.
     *
     * @param item The item being searched for.
     * @return True if the item exists in the sale, otherwise false.
     */
    private boolean isItemRegistered(ItemDTO item){
        for(ItemInSale registeredItem : itemsToPurchase) {
            if (isRegisteredItemAndItemAMatch(registeredItem, item))
                return true;
        }
        return false;
    }

    /**
     * Adds an item that already exists in the sale, to the sale.
     *
     * @param item The item being added.
     */
    private void addRegisteredItemToSale(ItemDTO item){
        for(ItemInSale registeredItem : itemsToPurchase){
            if(isRegisteredItemAndItemAMatch(registeredItem, item))
                increaseQuantityOfRegisteredItemByOne(registeredItem);
        }
        increaseRunningTotalAndTotalVAT(item);
    }

    /**
     * Adds an item that does not already exist in the sale, to the sale.
     * Sets its quantity to one in the sale.
     * @param item The item being added.
     */
    private void addNewItemToSale(ItemDTO item){
        ItemInSale itemBeingAdded = new ItemInSale(item, 1);
        itemsToPurchase.add(itemBeingAdded);
        increaseRunningTotalAndTotalVAT(item);
    }

    /**
     * Checks if an item registered in the sale is the same item as one being added.
     *
     * @param registeredItem The item registered in the sale.
     * @param item The item being added.
     * @return True if they are the same item, otherwise false.
     */
    private boolean isRegisteredItemAndItemAMatch(ItemInSale registeredItem, ItemDTO item){
        int registeredItemID = registeredItem.getItem().getItemID();
        int itemID = item.getItemID();
        return registeredItemID == itemID;
    }

    /**
     * Increases the quantity of an item already in the sale.
     *
     * @param registeredItem The item for which the quantity is being increased.
     */
    private void increaseQuantityOfRegisteredItemByOne(ItemInSale registeredItem){
        registeredItem.setQuantity(registeredItem.getQuantity() + 1);
    }

    /**
     * Increases the running total and the total VAT of a sale when an item is added.
     *
     * @param item The item being added.
     */
    private void increaseRunningTotalAndTotalVAT(ItemDTO item){
        Amount priceWithoutVAT = item.getPrice();
        Amount VATForItem = new Amount(item.getPrice().getAmount() * item.getVAT());
        Amount priceWithVAT = priceWithoutVAT.plus(VATForItem);
        Amount newRunningTotal = runningTotal.plus(priceWithVAT);
        runningTotal = newRunningTotal;
        totalVAT = totalVAT.plus(VATForItem);
    }

    /**
     * Ends the ongoing sale. Sets the time and date of the sale.
     *
     * @return The running total of the sale.
     */
    public Amount endSale(){
        timeOfSale = LocalTime.now();
        dateOfSale = LocalDate.now();
        return runningTotal;
    }


    /**
     * Prints the receipt corresponding to the sale.
     * @param printer The printer that is to print the receipt.
     */
    public void printReceipt(Printer printer){
        printer.printReceipt(receipt);
    }

    /**
     * Gets the running total of the sale.
     * @return The running total.
     */
    public Amount getRunningTotal() {
        return runningTotal;
    }

    /**
     * Gets the total VAT of the sale.
     * @return The total VAT.
     */
    public Amount getTotalVAT() {
        return totalVAT;
    }

    /**
     * Gets the registered items in the sale.
     * @return The registered items in the sale.
     */
    public List<ItemInSale> getRegisteredItems() {
        return itemsToPurchase;
    }

    /**
     * Gets the date of the sale.
     * @return The date of the sale.
     */
    public LocalDate getDateOfSale() {
        return dateOfSale;
    }

    /**
     * Gets the time of the sale.
     * @return The time of the sale.
     */
    public LocalTime getTimeOfSale() {
        return timeOfSale;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment){
        this.payment = payment;
    }
}