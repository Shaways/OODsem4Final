package se.kth.iv1350.seminar4.util;

/**
 *
 * The <code>Amount</code> a class that defines the amount of money or items.
 */

public class Amount {
    private final Double amount;

    /**
     * Creates an instance of the class.
     *
     * @param amount The amount of money.
     */
    public Amount(Double amount){
        this.amount = amount;
    }

    public Amount(){this.amount = 0.0;}

    /**
     * Gets the numerical value of the amount.
     * @return The numerical value of the amount.
     */
    public Double getAmount(){
        return amount;
    }

    /**
     * Checks if one <code>Amount</code>> is equal to another <code>Amount</code>>.
     *
     * @param other The other amount.
     * @return True if the amounts are equal, false if they are not.
     */
    public boolean equals(Object other){
        if(other == null || !(other instanceof Amount))
            return false;
        Amount otherAmount = (Amount) other;
        return amount.equals(otherAmount.amount);
    }

    /**
     * Takes the specified specified amount and subtracts.
     *
     * @param other The amount being subtracted.
     * @return A new Amount with the difference as its numerical value.
     */
    public Amount minus(Amount other){
        return new Amount(amount - other.amount);
    }

    /**
     * Adds the stated amount.
     *
     * @param other The amount being added.
     * @return A new Amount with the sum as its numerical value.
     */
    public Amount plus(Amount other){
        return new Amount(amount + other.amount);
    }

    /**
     * Changes amount to a string object.
     * Rounded to two decimals, e.g. "10.50".
     *
     * @return The string representation of the Amount.
     */
    public String toString(){
        return String.format("%.2f", amount);
    }
}


