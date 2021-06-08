package se.kth.iv1350.seminar4.model;

import se.kth.iv1350.seminar4.Integration.StoreDTO;

/**
 *
 * Represents one receipt. Contains information about one sale and proves the payment of that sale.
 */
public class Receipt {
    private StoreDTO store;
    private Sale sale;

    /**
     * Makes a new instance, defining a receipt.
     *
     * @param store The store in which the sale, that the receipt contains information about, is taking place.
     * @param sale The sale that the receipt contains information about.
     */
    Receipt(StoreDTO store, Sale sale){
        this.store = store;
        this.sale = sale;
    }

    /**
     * Method to return a string representation of the receipt.
     * @return The string representation of the receipt
     */
    public String toString(){
        StringBuilder receipt = new StringBuilder();
        receipt.append("\n");
        appendLine(receipt,"          RECEIPT          ");
        appendLine(receipt,"Date: " + sale.getDateOfSale());
        appendLine(receipt,"Time: " + sale.getTimeOfSale());
        appendLine(receipt, store.toString());
        appendLine(receipt, "Items: ");
        receipt.append(registeredItemsToString());
        appendLine(receipt, "Total price: " + sale.getRunningTotal());
        appendLine(receipt, "Total VAT: " + sale.getTotalVAT());
        appendLine(receipt, "Amount paid: " + sale.getPayment().getPaidAmount());
        appendLine(receipt, "Change returned: " + sale.getPayment().getChange());
        appendLine(receipt, "          END OF RECEIPT          ");
        return receipt.toString();
    }

    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }
    
    
    private String registeredItemsToString(){
        StringBuilder registeredItemsBuilder = new StringBuilder();
        for(ItemInSale item : sale.getRegisteredItems()){
            registeredItemsBuilder.append(item.toString() + "\n");
        }
        return registeredItemsBuilder.toString();
    }
}


