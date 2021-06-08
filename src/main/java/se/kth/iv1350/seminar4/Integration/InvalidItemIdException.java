package se.kth.iv1350.seminar4.Integration;

/**
 * The <code>InvalidItemIdException</code> is thrown when the search for an itemID in 
 * the inventorysystem fails to return the searched item.
 * 
 */
public class InvalidItemIdException extends Exception {
    private final int invalidItemID;

    /**
     * Creates a new instance of the exception with the invalid itemID.
     * @param itemID The invalid itemID.
     */
    public InvalidItemIdException(int itemID){
        super("Item with ID: " + itemID + " not found. User must enter a VALID ID or item needs to be added to archive.");
        this.invalidItemID = itemID;
    }

    /**
     * Gets the invalid itemID.
     * @return The invalid itemID.
     */
    public int getInvalidItemID(){
        return invalidItemID;
    }
}
