package se.kth.iv1350.seminar4.Integration;
    
import se.kth.iv1350.seminar4.util.Amount;

 /**
 *
 * The <code>ItemDTO</code> class is a DTO representing an item not yet added to a sale.
 */
public class ItemDTO {
    private final Amount price;
    private final Double VAT;
    private final String description;
    private final int itemID;

    /**
     * Creates an instance of an item.
     *
     * @param price The price of the item.
     * @param VAT The VAT rate of the item.
     * @param description The description of the item.
     * @param itemID The id of the item.
     */
    ItemDTO(Amount price, Double VAT, String description, int itemID){
        this.price = price;
        this.VAT = VAT;
        this.description = description;
        this.itemID = itemID;
    }

    /**
     * Gets the price of the item.
     * @return The price of the item.
     */
    public Amount getPrice() {
        return price;
    }

    /**
     * Gets the VAT rate of the item.
     * @return The VAT rate of the item.
     */
    public Double getVAT() {
        return VAT;
    }

    /**
     * Gets the description of the item.
     * @return The description of the item.
     */
    public String getDescription(){
        return description;
    }

    /**
     * Gets the id of the item.
     * @return The id of the item.
     */
    public int getItemID() {
        return itemID;
    }
}
    
