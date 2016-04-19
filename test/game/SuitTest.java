/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bryner
 */
public class SuitTest {

    /**
     *
     */
    public Suit suit;
    
    /**
     *
     */
    public SuitTest() {
        
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
        suit = new Suit("Clubs");
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
     * Test of buildSuits method, of class Suit.
     */
    @Test
    public void testBuildSuits() {
        System.out.println("Suit.getValue() --");
        System.out.println("----------------------------------------");
        
        int expResult = 13;
        int result = suit.buildSuits().size();
        
        System.out.println("Expecting # of cards: " + expResult);
        System.out.println("Result # of cards:    " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Suit.
     */
    @Test
    public void testToString() {
        System.out.println("Suit.toString --");
        System.out.println("----------------------------------------");
        
        String expResult = "{\"suitName\":\"" + suit.suitName + "\"}";
        String result = suit.toString();
        
        System.out.println("Expecting: " + expResult);
        System.out.println("Result:    " + result);
        
        assertEquals(expResult, result);
    }
}
