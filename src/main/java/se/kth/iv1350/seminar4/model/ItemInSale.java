package se.kth.iv1350.seminar4.model;

import se.kth.iv1350.seminar4.Integration.ItemDTO;

/**
 *
 * <code>ItemInSale</code> is a class representing an item, or several of the same item, that has been added to a sale.
 */
public class ItemInSale {
    private final ItemDTO item;
    private int quantity;

    /**
     * Creates an instance of an item in a sale.
     *
     * @param item The item being added to a sale.
     * @param quantity The quantity of the item in the sale.
     */
    ItemInSale(ItemDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Gets the item of the <code>ItemInSale</code>.
     *
     * @return The item of the ItemInSale.
     */
    public ItemDTO getItem() {
        return item;
    }

    /**
     * Gets the quantity of the item in the sale.
     *
     * @return The quantity of the item in the sale.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of an item in the sale.
     *
     * @param quantity The quantity to be set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Creates a clear string representation of the <code>ItemInSale</code> object.
     *
     * @return The string representation.
     */
    public String toString(){
        return item.getDescription() + " " + "Price per: " + item.getPrice().getAmount() + " Amount: " + quantity;
    }
}