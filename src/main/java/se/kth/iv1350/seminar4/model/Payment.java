package se.kth.iv1350.seminar4.model;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.seminar4.util.Amount;

/**
 * A payment for a particular sale is represented by this class.
 */
public class Payment {
    private List<PaymentObserver> paymentObservers = new ArrayList();
    private Amount paidAmount;
    private Amount totalPriceForSale;
    private Amount change;

    /**
     * Creates a new instance of the class.
     * @param paidAmount The amount being paid.
     * @param totalPriceForSale The total price for the sale being paid for.
     */
    public Payment(Amount paidAmount, Amount totalPriceForSale){
        this.paidAmount = paidAmount;
        this.totalPriceForSale = totalPriceForSale;
    }

    /**
     * Gets the paid amount.
     * @return The paid amount.
     */
    public Amount getPaidAmount() {
        return paidAmount;
    }

    /**
     * Gets the total price of the sale being paid for.
     * @return The total price of the sale being paid for.
     */
    public Amount getTotalPriceForSale() {
        return totalPriceForSale;
    }

    /**
     * Calculates the change to be returned. Also handles notifying the observers.
     * @return The change to be returned.
     */
    public Amount calculateChange() {
        Amount change = paidAmount.minus(totalPriceForSale);
        this.change = change;
        notifyObservers();
        return change;
    }

    /**
     * Gets the amount of change to be returned.
     * @return The amount of change to be returned.
     */
    public Amount getChange(){
        return change;
    }

    private void notifyObservers(){
        for (PaymentObserver obs : paymentObservers) {
            obs.updateTotal(totalPriceForSale);
        }
    }

    /**
     * The specified observers will be notified when a payment is made.
     * @param observers The observers to notify.
     */
    public void addPaymentObservers(List<PaymentObserver> observers) {
        paymentObservers.addAll(observers);
    }

}


