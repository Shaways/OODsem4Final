package se.kth.iv1350.seminar4.model;

import se.kth.iv1350.seminar4.Integration.ItemDTO;
import se.kth.iv1350.seminar4.util.Amount;

/**
 *
 * <code>DisplayInfoDTO</code> is a DTO representing what is to be displayed during a sale when an item is scanned. In this
 * application it is sent to the view after an item is scanned.
 */
public class DisplayInfoDTO {
    private final ItemDTO item;
    private final Amount runningTotal;

    /**
     * Creates an instance of the class.
     *
     * @param item The item that was scanned.
     * @param runningTotal The current running total of the sale in which the item was scanned.
     */
    public DisplayInfoDTO(ItemDTO item, Amount runningTotal){
        this.item = item;
        this.runningTotal = runningTotal;
    }

    /**
     * Gets the running total.
     * @return The running total.
     */
    public Amount getRunningTotal() {
        return runningTotal;
    }

    /**
     * Gets the item.
     * @return The item.
     */
    public ItemDTO getItem() {
        return item;
    }
}