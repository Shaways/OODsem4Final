package se.kth.iv1350.seminar4.Integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.seminar4.model.Sale;
import se.kth.iv1350.seminar4.util.Amount;

/**
 * The <code>InventorySystem</code> class handles retrieval of items from the external inventory system.
 * Not implemented as a database here, but a placeholder where the data is stored in this object.
 */

public class InventorySystem {
    public List<ItemDTO> items = new ArrayList<>();

    /**
     * Creates an object of this class and adds it with several <code>ItemDTO</code>.
     */
    InventorySystem(){
        addToItemList();
    }

    private void addToItemList(){
        items.add(new ItemDTO(new Amount(12.50), 0.33, "Mango", 303));
        items.add(new ItemDTO(new Amount(2.50), 0.15, "Lettuce", 313));
        items.add(new ItemDTO(new Amount(1.50), 0.11, "Apple", 315));
        items.add(new ItemDTO(new Amount(3.05), 0.20, "Cucumber", 325));
        items.add(new ItemDTO(new Amount(65.49), 0.13, "Whiskey", 359));
    }

    /**
     * Fetches an item from the external inventory system with the provided itemID.
     *
     * @param itemID The provided itemID.
     * @return The fetched item if it is found.
     * @throws InvalidItemIdException If the itemID does not exist in the <code>InventorySystem</code>
     * @throws InventorySystemException If the database can not be called. Hardcoded in this implementation
     * since no database exists.
     */
    public ItemDTO fetchItem(int itemID) throws InvalidItemIdException {
        int hardCodedItemIDForDBFailure = 9999;
        if(itemID == hardCodedItemIDForDBFailure)
            throw new InventorySystemException("Database can not be called.");
        if(!isItemInInventory(itemID))
            throw new InvalidItemIdException(itemID);
        ItemDTO fetchedItem = null;
        for (ItemDTO item : items){
            if(item.getItemID() == itemID) {
                fetchedItem = item;
            }
        }
        return fetchedItem;
    }

    private boolean isItemInInventory(int itemID){
        for(ItemDTO item : items){
            if(item.getItemID() == itemID)
                return true;
        }
        return false;
    }

    /**
     * Placeholder for reporting sales to the external inventory system.
     *
     * @param sale The finished sale to be reported.
     */
    public void updateSystem(Sale sale){

    }
}