/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bryner
 */
public class HandTest {
    
    private List playerDummy;
    private Hand player;
    private List deck;
    
    public HandTest() {
        
    }
    
    @Before
    public void setUp() {
        playerDummy = new ArrayList<>();
        player = new Hand("Player", playerDummy);
        deck = new Deck().getNewDeck();
        System.out.print("-- Testing ");
    }
    
    @After
    public void tearDown() {
        System.out.println("----------------------------------------\n\n");
    }

    /**
     * Test of returnHandArray method, of class Hand.
     */
    @Test
    public void testReturnHandArray() {
        System.out.println("Hand.returnHandArray() --");
        System.out.println("----------------------------------------");
        
        int noOfCards = 7;
        player.takeCardFromDeck(deck, noOfCards);
        int expResult = noOfCards;
        int result = player.hand.size();
        
        System.out.println("Expected hand size: " + expResult);
        System.out.println("Result hand size:   " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of takeCardFromDeck method, of class Hand.
     */
    @Test
    public void testTakeCardFromDeck() {
        System.out.println("Hand.takeCardFromDeck() --");
        System.out.println("----------------------------------------");
        
        int noOfCards = 15;
        player.takeCardFromDeck(deck, noOfCards);
        int expResult = 52 - noOfCards;
        int result = deck.size();
        
        System.out.println("Expected deck size: " + expResult);
        System.out.println("Result deck size:   " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Hand.
     */
    @Test
    public void testToString() {
        System.out.println("Hand.toString() --");
        System.out.println("----------------------------------------");
        
        String expResult = "{\"name\":\"" + player.name + "\", \"hand\":" + player.hand + "}";
        String result = player.toString();
        
        System.out.println("Expecting: " + expResult);
        System.out.println("Result:    " + result);
        
        assertEquals(expResult, result);
    }
    
}
