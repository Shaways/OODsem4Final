package se.kth.iv1350.seminar4.view;

import se.kth.iv1350.seminar4.model.PaymentObserver;
import se.kth.iv1350.seminar4.util.Amount;


/**
 * <code>TotalRevenueView</code> displays the total revenue since the program was started, every time a
 * sale has been paid for.
 */
public class TotalRevenueView implements PaymentObserver {
    private Amount totalRevenue;

    /**
     * Creates a new instance of the class.
     */
    public TotalRevenueView(){
        totalRevenue = new Amount();
    }


    /**
     * Updates the total revenue and displays it.
     * @param revenue The amount to be added to the total revenue.
     */
    @Override
    public void updateTotal(Amount revenue){
        totalRevenue = totalRevenue.plus(revenue);
        printTotalRevenue();
    }

    private void printTotalRevenue(){
        System.out.println("\n        **REVENUE DISPLAY**        ");
        System.out.println("         Amount: " + totalRevenue);
        System.out.println("        **REVENUE DISPLAY**        ");
    }
}