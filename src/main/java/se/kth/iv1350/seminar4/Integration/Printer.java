package se.kth.iv1350.seminar4.Integration;

import se.kth.iv1350.seminar4.model.Receipt;


/**
 * The <code>ReceiptPrinter</code> class handles communication with the external printer system.
 * Implemented as a placeholder here that prints to system.out.
 */
public class Printer {

    /**
     * Creates a new instance of the class.
     */
    Printer(){

    }

    /**
     * Prints the receipt. Implemented as a placeholder that simply prints to system.out.
     *
     * @param receipt The receipt to be printed.
     */
    public void printReceipt(Receipt receipt){
        System.out.println(receipt);
    }
}