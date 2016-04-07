/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bryner
 */

public class ControllerTest {
    
    public ControllerTest() {
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
     * Test of getFinaldeck method, of class Controller.
     */
    @Test
    public void testGetFinaldeck() {
        System.out.println("getFinaldeck");
        Controller instance = new Controller();
        List expResult = null;
        List result = instance.getFinaldeck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFinaldeck method, of class Controller.
     */
    @Test
    public void testSetFinaldeck() {
        System.out.println("setFinaldeck");
        List finaldeck = null;
        Controller instance = new Controller();
        instance.setFinaldeck(finaldeck);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinBet method, of class Controller.
     */
    @Test
    public void testGetMinBet() {
        System.out.println("getMinBet");
        Controller instance = new Controller();
        double expResult = 0.0;
        double result = instance.getMinBet();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMinBet method, of class Controller.
     */
    @Test
    public void testSetMinBet() {
        System.out.println("setMinBet");
        double minBet = 0.0;
        Controller instance = new Controller();
        instance.setMinBet(minBet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxBet method, of class Controller.
     */
    @Test
    public void testGetMaxBet() {
        System.out.println("getMaxBet");
        Controller instance = new Controller();
        double expResult = 0.0;
        double result = instance.getMaxBet();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxBet method, of class Controller.
     */
    @Test
    public void testSetMaxBet() {
        System.out.println("setMaxBet");
        double maxBet = 0.0;
        Controller instance = new Controller();
        instance.setMaxBet(maxBet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalance method, of class Controller.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        Controller instance = new Controller();
        double expResult = 0.0;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBalance method, of class Controller.
     */
    @Test
    public void testSetBalance() {
        System.out.println("setBalance");
        double balance = 0.0;
        Controller instance = new Controller();
        instance.setBalance(balance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeBalance method, of class Controller.
     */
    @Test
    public void testRemoveBalance() {
        System.out.println("removeBalance");
        double balance = 0.0;
        Controller instance = new Controller();
        instance.removeBalance(balance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerBet method, of class Controller.
     */
    @Test
    public void testGetPlayerBet() {
        System.out.println("getPlayerBet");
        Controller instance = new Controller();
        double expResult = 0.0;
        double result = instance.getPlayerBet();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayerBet method, of class Controller.
     */
    @Test
    public void testSetPlayerBet() {
        System.out.println("setPlayerBet");
        double playerBet = 0.0;
        Controller instance = new Controller();
        instance.setPlayerBet(playerBet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreviousWin method, of class Controller.
     */
    @Test
    public void testGetPreviousWin() {
        System.out.println("getPreviousWin");
        Controller instance = new Controller();
        double expResult = 0.0;
        double result = instance.getPreviousWin();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPreviousWin method, of class Controller.
     */
    @Test
    public void testSetPreviousWin() {
        System.out.println("setPreviousWin");
        double previousWin = 0.0;
        Controller instance = new Controller();
        instance.setPreviousWin(previousWin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOption method, of class Controller.
     */
    @Test
    public void testGetOption() {
        System.out.println("getOption");
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.getOption();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOption method, of class Controller.
     */
    @Test
    public void testSetOption() {
        System.out.println("setOption");
        String option = "";
        Controller instance = new Controller();
        instance.setOption(option);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHasPaidOut method, of class Controller.
     */
    @Test
    public void testGetHasPaidOut() {
        System.out.println("getHasPaidOut");
        Controller instance = new Controller();
        Boolean expResult = null;
        Boolean result = instance.getHasPaidOut();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHasPaidOut method, of class Controller.
     */
    @Test
    public void testSetHasPaidOut() {
        System.out.println("setHasPaidOut");
        Boolean hasPaidOut = null;
        Controller instance = new Controller();
        instance.setHasPaidOut(hasPaidOut);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCardAce method, of class Controller.
     */
    @Test
    public void testCheckCardAce() {
        System.out.println("checkCardAce");
        Card in = null;
        Controller instance = new Controller();
        Boolean expResult = null;
        Boolean result = instance.checkCardAce(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNewDeck method, of class Controller.
     */
    @Test
    public void testGetNewDeck() {
        System.out.println("getNewDeck");
        Controller instance = new Controller();
        instance.getNewDeck();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotal method, of class Controller.
     */
    @Test
    public void testReturnTotal() {
        System.out.println("returnTotal");
        List hand = null;
        Boolean showTotal = null;
        Controller instance = new Controller();
        double expResult = 0.0;
        double result = instance.returnTotal(hand, showTotal);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Controller.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Controller.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
