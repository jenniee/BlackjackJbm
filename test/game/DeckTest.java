/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bryner
 */
public class DeckTest {
    
    /**
     *
     */
    public DeckTest() {
        
    }
    

    /**
     * Test of getNewDeck method, of class Deck.
     */
    @Test
    public void testGetNewDeck() {
        System.out.println("-- Testing Deck.getNewDeck() --");
        System.out.println("----------------------------------------");

        Deck instance = new Deck();

        int expResult = 52;
        int result = instance.getNewDeck().size();
        
        System.out.println("Expected Deck size: " + expResult);
        System.out.println("Result Deck size:   " + result);
        System.out.println("---------------------------------------- \n\n");
        
        assertEquals(expResult, result);
    }
    
}
