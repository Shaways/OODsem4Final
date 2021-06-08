package se.kth.iv1350.seminar4.Integration;

import se.kth.iv1350.seminar4.Integration.AccountingSystem;
import se.kth.iv1350.seminar4.Integration.InventorySystem;
import se.kth.iv1350.seminar4.Integration.Printer;


/**
 *
 * The <code>SystemCreator</code> class handles creation of the three external systems,
 * the accounting system, the inventory system and the system communicating with the receipt printer.
 */
public class SystemCreator {
    private AccountingSystem accSys;
    private InventorySystem invSys;
    private Printer printer;

    /**
     * Creates a new instance of the class.
     */
    public SystemCreator(){
        accSys = new AccountingSystem();
        invSys = new InventorySystem();
        printer = new Printer();
    }

    /**
     * Getter that retrieves the value of accountingSystem.
     * @return The accounting system value.
     */
    public AccountingSystem getAccountingSystem() {
        return accSys;
    }

    /**
     * Getter that retrieves the value of inventorySystem.
     * @return The inventory system value.
     */
    public InventorySystem getInventorySystem() {
        return invSys;
    }

    /**
     * Gets the receipt printer.
     * @return The receipt printer.
     */
    public Printer getPrinter() {
        return printer;
    }
}

