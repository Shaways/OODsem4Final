package se.kth.iv1350.seminar4.model;

import se.kth.iv1350.seminar4.util.Amount;

/**
 * A listener interface for receiving information about sales that have been paid for.
 * Classes that wants to get such notifications implements this interface. The object
 * created with that class is registered with
 * {@link se.kth.iv1350.seminar4.controller.Controller#addPaymentObserver(PaymentObserver)}.
 * When a sale has been paid for that object's {@link #update(Amount)} method is called.
 *
 */
public interface PaymentObserver {

    /**
     * Invoked when a sale has been paid for.
     * @param revenue The revenue of the sale that has been paid for.
     */
    void updateTotal(Amount revenue);
}



