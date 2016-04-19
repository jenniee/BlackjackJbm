/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
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
    Controller instance;
    
    /**
     *
     */
    public ControllerTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
        instance = new Controller();
        
        System.out.print("-- Testing ");
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
        System.out.println("----------------------------------------\n\n");
    }

    /**
     * Test of getFinaldeck method, of class Controller.
     */
    @Test
    public void testGetFinaldeck() {
        System.out.println("Controller.getFinaldeck() --");
        System.out.println("----------------------------------------");

        instance.setFinaldeck(new Deck().getNewDeck());
        
        int expResult = 52;
        int result = instance.getFinaldeck().size();
        
        System.out.println("Expected deck size: " + expResult);
        System.out.println("Result deck size:   " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setFinaldeck method, of class Controller.
     */
    @Test
    public void testSetFinaldeck() {
        System.out.println("Controller.setFinaldeck() --");
        System.out.println("----------------------------------------");

        List finaldeck = new Deck().getNewDeck();
        instance.setFinaldeck(finaldeck);
        
        int expResult = 52;
        int result = finaldeck.size();
        
        System.out.println("Expected deck size: " + expResult);
        System.out.println("Result deck size:   " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinBet method, of class Controller.
     */
    @Test
    public void testGetMinBet() {
        System.out.println("Controller.getMinBet() --");
        System.out.println("----------------------------------------");
        
        instance.setMinBet(10);
        double expResult = 10;
        double result = instance.getMinBet();
        
        System.out.println("Expected minBet: " + expResult);
        System.out.println("Result minBet:   " + result);
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setMinBet method, of class Controller.
     */
    @Test
    public void testSetMinBet() {
        System.out.println("Controller.setMinBet() --");
        System.out.println("----------------------------------------");

        double oldMinBet = 50;
        instance.setMinBet(oldMinBet);
        
        double newMinBet = 100;
        instance.setMinBet(newMinBet);
        double expResult = newMinBet;
        double result = instance.getMinBet();
        
        System.out.println("Old minBet:    " + oldMinBet);
        System.out.println("New minBet:    " + expResult);
        System.out.println("Result minBet: " + result);
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMaxBet method, of class Controller.
     */
    @Test
    public void testGetMaxBet() {
        System.out.println("Controller.getMaxBet() --");
        System.out.println("----------------------------------------");

        instance.setMaxBet(5000);

        double expResult = 5000;
        double result = instance.getMaxBet();
        
        System.out.println("Expected maxBet: " + expResult);
        System.out.println("Result maxBet:   " + result);
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setMaxBet method, of class Controller.
     */
    @Test
    public void testSetMaxBet() {
        System.out.println("Controller.setMaxBet() --");
        System.out.println("----------------------------------------");

        double oldMaxBet = 5000;
        instance.setMaxBet(oldMaxBet);
        
        double newMaxBet = 1000;
        instance.setMaxBet(newMaxBet);
        double expResult = newMaxBet;
        double result = instance.getMaxBet();
        
        System.out.println("Old maxBet:    " + oldMaxBet);
        System.out.println("New maxBet:    " + expResult);
        System.out.println("Result maxBet: " + result);
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getBalance method, of class Controller.
     */
    @Test
    public void testGetBalance() {
        System.out.println("Controller.getBalance() --");
        System.out.println("----------------------------------------");

        double initialBalance = 0; // New instances start with 0 chips
        double addChips = 1000;
        instance.setBalance(addChips);
        double expResult = addChips + initialBalance; // Add initial chip amount
        double result = instance.getBalance();
        
        System.out.println("Expected balance: " + expResult);
        System.out.println("Result balance:   " + result);
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setBalance method, of class Controller.
     */
    @Test
    public void testSetBalance() {
        System.out.println("Controller.setBalance() --");
        System.out.println("----------------------------------------");
        
        double initialBalance = 0; // New instances start with 0 chips
        double oldBalance = instance.getBalance();
        double addChips = 1000;
        instance.setBalance(addChips);
        double expResult = addChips + initialBalance; // Add initial chip amount
        double result = instance.getBalance();
        
        System.out.println("Old balance:    " + oldBalance);
        System.out.println("New balance:    " + expResult);
        System.out.println("Result balance: " + result);
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of removeBalance method, of class Controller.
     */
    @Test
    public void testRemoveBalance() {
        System.out.println("Controller.removeBalance() --");
        System.out.println("----------------------------------------");

        double initialBalance = 0; // New instances start with 0 chips
        double oldBalance = instance.getBalance();
        double chips = 500;
        instance.removeBalance(chips);
        double expResult = initialBalance - chips; // Add initial chip amount
        double result = instance.getBalance();
        
        System.out.println("Old balance:    " + oldBalance);
        System.out.println("New balance:    " + expResult);
        System.out.println("Result balance: " + result);
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPlayerBet method, of class Controller.
     */
    @Test
    public void testGetPlayerBet() {
        System.out.println("Controller.getPlayerBet() --");
        System.out.println("----------------------------------------");
        
        double betAmount = 500;
        instance.setBalance(1000.0);
        instance.setOption("newhand");
        instance.setPlayerBet(betAmount);
        double expResult = betAmount;
        double result = instance.getPlayerBet();
        
        System.out.println("Expected playerBet: " + expResult);
        System.out.println("Result playerBet:   " + result);
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPlayerBet method, of class Controller.
     */
    @Test
    public void testSetPlayerBet() {
        System.out.println("Controller.setPlayerBet() --");
        System.out.println("----------------------------------------");
        
        double oldPlayerBet = instance.getPlayerBet();
        instance.setBalance(1000.0);
        instance.setOption("newhand");
        double betAmount = 500;
        instance.setPlayerBet(betAmount);
        double expResult = betAmount;
        double result = instance.getPlayerBet();
        
        System.out.println("Old playerBet:    " + oldPlayerBet);
        System.out.println("New playerBet:    " + expResult);
        System.out.println("Result playerBet: " + result);
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPreviousWin method, of class Controller.
     */
    @Test
    public void testGetPreviousWin() {
        System.out.println("Controller.getPreviousWin() --");
        System.out.println("----------------------------------------");
        
        double winAmount = 500;
        instance.setPreviousWin(winAmount);
        double expResult = winAmount;
        double result = instance.getPreviousWin();
        
        System.out.println("Expected previousWin: " + expResult);
        System.out.println("Result previousWin:   " + result);
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPreviousWin method, of class Controller.
     */
    @Test
    public void testSetPreviousWin() {
        System.out.println("Controller.setPreviousWin() --");
        System.out.println("----------------------------------------");
        
        double oldWin = instance.getPreviousWin();
        double winAmount = 500;
        instance.setPreviousWin(winAmount);
        double expResult = winAmount;
        double result = instance.getPreviousWin();
        
        System.out.println("Old previousWin:    " + oldWin);
        System.out.println("New previousWin:    " + expResult);
        System.out.println("Result previousWin: " + result);
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getOption method, of class Controller.
     */
    @Test
    public void testGetOption() {
        System.out.println("Controller.getOption() --");
        System.out.println("----------------------------------------");
        
        String option = "hello";
        instance.setOption(option);
        String expResult = option;
        String result = instance.getOption();
        
        System.out.println("Expected option: " + expResult);
        System.out.println("Result option:   " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setOption method, of class Controller.
     */
    @Test
    public void testSetOption() {
        System.out.println("Controller.setOption() --");
        System.out.println("----------------------------------------");
        
        instance.setOption("hello");
        String oldOption = instance.getOption();
        
        String option = "world";
        instance.setOption(option);
        String expResult = option;
        String result = instance.getOption();
        
        System.out.println("Old option:    " + oldOption);
        System.out.println("New option:    " + expResult);
        System.out.println("Result option: " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getHasPaidOut method, of class Controller.
     */
    @Test
    public void testGetHasPaidOut() {
        System.out.println("Controller.getHasPaidOut() --");
        System.out.println("----------------------------------------");
        
        Boolean expResult = false; // Instance is false by default
        Boolean result = instance.getHasPaidOut();
        
        System.out.println("Expected hasPaidOut: " + expResult);
        System.out.println("Result hasPaidOut:   " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setHasPaidOut method, of class Controller.
     */
    @Test
    public void testSetHasPaidOut() {
        System.out.println("Controller.setHasPaidOut() --");
        System.out.println("----------------------------------------");

        Boolean hasPaidOut = true;
        instance.setHasPaidOut(hasPaidOut);
        Boolean expResult = true;
        Boolean result = instance.getHasPaidOut();
        
        System.out.println("Expected hasPaidOut: " + expResult);
        System.out.println("Result hasPaidOut:   " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of checkCardAce method, of class Controller.
     */
    @Test
    public void testCheckCardAce() {
        System.out.println("Controller.checkCardAce() --");
        System.out.println("----------------------------------------");
        
        Card in = new Card("11", "D");
        Boolean expResult = true;
        Boolean result = instance.checkCardAce(in);
        
        System.out.println("Expected if Ace: " + expResult);
        System.out.println("Result if Ace:   " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getNewDeck method, of class Controller.
     */
    @Test
    public void testGetNewDeck() {
        System.out.println("Controller.getNewDeck() --");
        System.out.println("----------------------------------------");

        instance.getNewDeck();
        int expResult = 52;
        int result = instance.getFinaldeck().size();
        
        System.out.println("Expected deck size: " + expResult);
        System.out.println("Result deck size:   " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of returnTotal method, of class Controller.
     */
    @Test
    public void testReturnTotal() {
        System.out.println("Controller.returnTotal() --");
        System.out.println("----------------------------------------");

        List <Card> hand = new ArrayList<>();
        
        Card card1 = new Card("2", "S");  // Value = 2       | Total = 2
        Card card2 = new Card("11", "D"); // Value = 11 or 1 | Total = 13
        Card card3 = new Card("J", "C");  // Value = 10      | Total = 13 <- Ace value = 1
        Card card4 = new Card("7", "S");  // Value = 7       | Total = 20
        Card card5 = new Card("11", "H"); // Value = 1       | Total = 21
        
        hand.add(0, card1);
        hand.add(1, card2);
        hand.add(2, card3);
        hand.add(3, card4);
        hand.add(4, card5);
        
        Boolean showTotal = true;
        double expResult = 21;
        double result = instance.returnTotal(hand, showTotal);
        
        System.out.println("Expected hand total: " + expResult);
        System.out.println("Result hand total:   " + result);
        
        assertEquals(expResult, result, 0.0);
    }
}