package se.kth.iv1350.seminar4.Integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.seminar4.util.Amount;


public class InventorySystemTest {
    private InventorySystem invSys;
    
    
    @BeforeEach
    public void setUp() {
        invSys = new InventorySystem();
    }
    
    @AfterEach
    public void tearDown() {
        invSys = null;
    }

    @Test
    public void testFetchItem() throws InvalidItemIdException {
        int idOfItemToFetch = 315;
        ItemDTO expectedItem = new ItemDTO(new Amount(1.50), 0.11, "Apple", 315);
        ItemDTO itemFetchedFromInventorySystem = invSys.fetchItem(idOfItemToFetch);
        boolean result = expectedItem.getItemID() == itemFetchedFromInventorySystem.getItemID(); 
        assertTrue(result, "Items were not equal");
    }
    
    @Test
    public void testFetchTwoDifferentItems() throws InvalidItemIdException {
        int idOfFirstItemToFetch = 303;
        int idOfSecondItemToFetch = 313;
        ItemDTO firstExpectedItem = new ItemDTO(new Amount(12.50), 0.33, "Mango", 303);
        ItemDTO firstItemFetchedFromInventorySystem = invSys.fetchItem(idOfFirstItemToFetch);
        ItemDTO secondExpectedItem = new ItemDTO(new Amount(2.50), 0.15, "Lettuce", 313);
        ItemDTO secondItemFetchedFromInventorySystem = invSys.fetchItem(idOfSecondItemToFetch);
        boolean resultOfFirst = firstExpectedItem.getItemID() == firstItemFetchedFromInventorySystem.getItemID();
        boolean resultOfSecond = secondExpectedItem.getItemID() == secondItemFetchedFromInventorySystem.getItemID();
        boolean result = (resultOfFirst && resultOfSecond);
        assertTrue(result, "One of the items fetched was not the expected one");
    }
    
    @Test
    public void testFetchTwoOfTheSameItem() throws InvalidItemIdException {
        int idOfItemToFetch = 325;
        ItemDTO firstExpectedItem = new ItemDTO(new Amount(3.05), 0.20, "Cucumber", 325);
        ItemDTO secondExpectedItem = new ItemDTO(new Amount(3.05), 0.20, "Cucumber", 325);
        ItemDTO firstFetchedItem = invSys.fetchItem(idOfItemToFetch);
        ItemDTO secondFetchedItem = invSys.fetchItem(idOfItemToFetch);
        boolean firstResult = firstExpectedItem.getItemID() == firstFetchedItem.getItemID();
        boolean secondResult = secondExpectedItem.getItemID() == secondFetchedItem.getItemID();
        boolean result = firstResult && secondResult;
        assertTrue(result, "One of the items fetched was not the expected one.");
    }
    
    @Test
    public void testFetchItemWithInvalidID(){
        int itemIDThatDoesNotExistInSystem = 999;
        try{
            invSys.fetchItem(itemIDThatDoesNotExistInSystem);
            fail("Fetched an item that does not exist in inventory system.");
        }
        catch(InvalidItemIdException expectedException){
            boolean exceptionContainsCorrectItemID = expectedException.getInvalidItemID() == itemIDThatDoesNotExistInSystem;
            assertTrue(exceptionContainsCorrectItemID,
                    "Wrong exception message, " +
                    "does not contain correct itemID: " +
                    itemIDThatDoesNotExistInSystem);
    }     
 }
    @Test
    public void testDBFailureWithHardcodedItemID(){
        int hardCodedItemIDForDBFailure = 9999;
        try{
            invSys.fetchItem(hardCodedItemIDForDBFailure);
            fail("Fetched item when DB failure should occur.");
        }
        catch(Exception expectedException){
            boolean correctTypeOfExceptionThrown = expectedException instanceof InventorySystemException;
            assertTrue(correctTypeOfExceptionThrown, "Wrong type of exception thrown.");
        }
    }
    
}
