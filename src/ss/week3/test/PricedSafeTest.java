package ss.week3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week3.bill.Bill;
import ss.week3.hotel.PricedSafe;

public class PricedSafeTest {

    private PricedSafe safe;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";
    
    public String CORRECT_PASSWORD;
    public String WRONG_PASSWORD;
    

    @BeforeEach
    public void setUp() throws Exception {
        safe = new PricedSafe(PRICE);
        CORRECT_PASSWORD = safe.getPassword().getInitPass();
        WRONG_PASSWORD = CORRECT_PASSWORD + "WRONG";
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
    
    @Test
    public void testActivateWithWrongPass() {
    	safe.activate("SomeWrongPassword");
    	assertFalse(safe.isActive());
    	assertFalse(safe.isOpen());
    }
    
    @Test
    public void testActivateWithRightPass() {
    	safe.activate("password");
    	assertTrue(safe.isActive());
    	assertFalse(safe.isOpen());
    }
    
    @Test
    public void testOpenWithWrongPassWhenDeactivated() {
    	safe.deactivate();
    	safe.open("WrongPassword");
    	assertFalse(safe.isActive());
    	assertFalse(safe.isOpen());
    }
    
    @Test
    public void testOpenWithRightPassWhenDeactivated() {
    	safe.deactivate();
    	safe.open("password");
    	assertFalse(safe.isActive());
    	assertFalse(safe.isOpen());
    }
    
    @Test
    public void testOpenWhenActive() {
    	safe.activate("password");
    	safe.open("WrongPassword");
    	assertFalse(safe.isOpen());
    	
    	safe.open("password");
    	assertTrue(safe.isOpen());
    	assertTrue(safe.isActive());
    }
    
    @Test
    public void testOpenAndClose() {
    	safe.activate("password");
    	safe.open("password");
    	
    	safe.close();
    	assertTrue(safe.isActive());
    	assertFalse(safe.isOpen());
    }
    
    @Test
    public void testCloseDeactivatedSafe() {
    	safe.deactivate();
    	safe.close();
 
    	assertFalse(safe.isActive());
    	assertFalse(safe.isOpen());
    }
    
    @Test
    public void testIsBillItem() throws Exception {
    	assertTrue(safe instanceof Bill.Item, 
    			"safe should be an instance of Bill.Item.");
        assertEquals(PRICE, safe.getAmount(), 0, 
        		"GetAmount should return the price of the safe.");
    }
}
