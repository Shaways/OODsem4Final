package se.kth.iv1350.seminar4.Integration;


/**
 * The <code>InventorySystemException</code> is thrown when something goes wrong while performing
 * an operation in the <code>InventorySystem</code>.
 * In this implementation it is only thrown when a <code>fetchItem</code> call is made with the
 * hardcoded itemID simulating a database failure.
 */

public class InventorySystemException extends RuntimeException {

    /**
     * Creates a new instance of the exception with a specified message describing the exception.
     *
     * @param message The message describing the exception.
     */
    public InventorySystemException(String message){
        super(message);
    }
}