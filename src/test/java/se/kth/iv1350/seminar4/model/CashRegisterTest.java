package se.kth.iv1350.seminar4.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.seminar4.util.Amount;

public class CashRegisterTest {
    private CashRegister cashRegister;
    
    @BeforeEach
    public void setUp() {
        cashRegister = new CashRegister(new Amount(500.0));
    }
    
    @AfterEach
    public void tearDown() {
        cashRegister = null;
    }

    @Test
    public void testUpdateBalance() {
        Amount amountToAdd = new Amount(100.0);
        Amount amountToRemove = new Amount(20.0);
        Amount expectedAmountAfterUpdate = new Amount(500.0 + 100.0 - 20.0);
        cashRegister.updateBalance(amountToAdd, amountToRemove);
        Amount actualAmountAfterUpdate = cashRegister.getBalance();
        assertEquals(expectedAmountAfterUpdate, actualAmountAfterUpdate, "The updated balance does not match the expected value");
    
    }

    @Test
    public void testUpdateBalanceOneNegativeValue(){
        Amount amountToAdd = new Amount(-100.0);
        Amount amountToRemove = new Amount(20.0);
        Amount expectedAmountAfterUpdate = new Amount(500.0 + (-100.0) - 20.0);
        cashRegister.updateBalance(amountToAdd, amountToRemove);
        Amount actualAmountAfterUpdate = cashRegister.getBalance();
        assertEquals(expectedAmountAfterUpdate, actualAmountAfterUpdate,
                "The updated balance does not match the expected value");
    }
    
    @Test
    public void testUpdateBalanceZeroValue(){
        Amount amountToAdd = new Amount(0.0);
        Amount amountToRemove = new Amount(20.0);
        Amount expectedAmountAfterUpdate = new Amount(500.0 + 0.0 - 20.0);
        cashRegister.updateBalance(amountToAdd, amountToRemove);
        Amount actualAmountAfterUpdate = cashRegister.getBalance();
        assertEquals(expectedAmountAfterUpdate, actualAmountAfterUpdate,
                "The updated balance does not match the expected value");
    }
    
    @Test
    public void testUpdateBalanceTwoZeroValueS(){
        Amount amountToAdd = new Amount(0.0);
        Amount amountToRemove = new Amount(0.0);
        Amount expectedAmountAfterUpdate = new Amount(500.0 + 0.0 - 0.0);
        cashRegister.updateBalance(amountToAdd, amountToRemove);
        Amount actualAmountAfterUpdate = cashRegister.getBalance();
        assertEquals(expectedAmountAfterUpdate, actualAmountAfterUpdate,
                "The updated balance does not match the expected value");  
    }
    
    @Test
    public void testUpdateBalanceTwoNegativeValues(){
        Amount amountToAdd = new Amount(-100.0);
        Amount amountToRemove = new Amount(-20.0);
        Amount expectedAmountAfterUpdate = new Amount(500.0 + (-100.0) - (-20.0));
        cashRegister.updateBalance(amountToAdd, amountToRemove);
        Amount actualAmountAfterUpdate = cashRegister.getBalance();
        assertEquals(expectedAmountAfterUpdate, actualAmountAfterUpdate,
                "The updated balance does not match the expected value");
    }
}
        