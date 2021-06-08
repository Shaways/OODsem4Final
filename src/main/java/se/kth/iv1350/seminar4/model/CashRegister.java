package se.kth.iv1350.seminar4.model;

import se.kth.iv1350.seminar4.util.Amount;

/**
 *
 * The <code>CashRegister</code> class represents a made up cash register with a certain amount of money in it.
 */
public class CashRegister {
    private Amount balance;

    /**
     * Creates an instance of the class.
     */
    public CashRegister(Amount balance){
        this.balance = balance;
    }

    /**
     * Balance is updated. This is done when a sale is paid for.
     *
     * @param paidAmount The amount paid by the customer.
     * @param change The amount of change given to the customer.
     */
    public void updateBalance(Amount paidAmount, Amount change){
        Amount amountToAdd = paidAmount.minus(change);
        balance = balance.plus(amountToAdd);
    }

    /**
     * Getter that retrieves the value of balance in cash register.
     * @return The balance in the cash register.
     */
    public Amount getBalance() {
        return balance;
    }

}