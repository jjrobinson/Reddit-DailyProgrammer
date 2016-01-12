/*
 * 
 */
package common;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JasonRobinson
 */
public class PriceTest {
    
    public PriceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Price.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Price instance = new Price();
        String expResult = "0.0";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class Price.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int d = 0;
        int c = 0;
        Price instance = new Price();
        instance.set(d, c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDollars method, of class Price.
     */
    @Test
    public void testGetDollars() {
        System.out.println("getDollars");
        Price instance = new Price();
        int expResult = 0;
        int result = instance.getDollars();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDollars method, of class Price.
     */
    @Test
    public void testSetDollars() {
        System.out.println("setDollars");
        int dollars = 0;
        Price instance = new Price();
        instance.setDollars(dollars);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCents method, of class Price.
     */
    @Test
    public void testGetCents() {
        System.out.println("getCents");
        Price instance = new Price();
        int expResult = 0;
        int result = instance.getCents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCents method, of class Price.
     */
    @Test
    public void testSetCents() {
        System.out.println("setCents");
        int cents = 0;
        Price instance = new Price();
        instance.setCents(cents);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNegative method, of class Price.
     */
    @Test
    public void testIsNegative() {
        System.out.println("isNegative");
        Price instance = new Price();
        boolean expResult = false;
        boolean result = instance.isNegative();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Simple Test of subtract method, of class Price.
     */
    @Test
    public void testSimpleSubtract() {
        System.out.println("subtract");
        Price newP = new Price(1,0);
        Price instance = new Price(2,0);
        Price result = instance.subtract(newP);
       
        assertEquals("ERROR: simpleSubtract failed on dollars.", result.getDollars(), 1);
        assertEquals("ERROR: simpleSubtract failed on cents.", result.getCents(), 0);
    }


    /**
     * Simple Test of subtract method, of class Price.
     */
    @Test
    public void testSubtractToGetNegative() {
        System.out.println("subtract");
        Price newP = new Price(3,0);
        Price instance = new Price(2,1);
        Price result = instance.subtract(newP);
       
        assertEquals("ERROR: testSubtractToGetNegative failed on dollars.", result.getDollars(), 0);
        assertEquals("ERROR: testSubtractToGetNegative failed on cents.", result.getCents(), -99);
        assertTrue("ERROR: testSubtractToGetNegative failed on negative sign.", result.isNegative());
    }

    /**
     * Test of isGreater method, of class Price, returning TRUE
     */
    @Test
    public void testIsGreaterTrue() {
        System.out.println("isGreater");
        Price newP = new Price(1,0);
        Price instance = new Price(2,0);
        boolean result = instance.isGreater(newP);
        assertTrue("ERRROR: isGreater failed.", result);
    }

    /**
     * Test of isGreater method, of class Price, returning FALSE
     */
    @Test
    public void testIsGreaterFalse() {
        System.out.println("isGreater");
        Price newP = new Price(0,0);
        Price instance = new Price(-1,0);
        boolean expResult = false;
        boolean result = instance.isGreater(newP);
        assertFalse("ERRROR: isGreaterFalse failed.", result);
    }

    /**
     * Test of isEqual method, of class Price.
     */
    @Test
    public void testIsEqualTrue() {
        System.out.println("isEqual");
        Price newP = new Price(12,0);
        Price instance = new Price(12,0);
        assertTrue("ERROR: isEqual failed.", instance.isEqual(newP));
    }
    /**
     * Test of isEqual method, of class Price.
     */
    @Test
    public void testIsEqualFalse() {
        System.out.println("isEqual");
        Price newP = new Price(12,0);
        Price instance = new Price(13,0);
        assertFalse("ERROR: isEqual failed.", instance.isEqual(newP));
    }
    
}
