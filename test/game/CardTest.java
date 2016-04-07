/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bryner
 */
public class CardTest {
    
    public Card instance;
    public String card;
    public String suit;
    
    public CardTest() {
        
    }
    
    @Before
    public void setUp() {
        card = "J";
        suit = "Spades";
        instance = new Card(card, suit);
        System.out.print("-- Testing ");
    }

    @After
    public void tearDown() {
        System.out.println("----------------------------------------\n\n");

    }
    
    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue() {
        System.out.println("Card.getValue() --");
        System.out.println("----------------------------------------");

        String expResult = card;
        String result = instance.getValue();
        
        System.out.println("Card value:   " + card);
        System.out.println("Result value: " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class Card.
     */
    @Test
    public void testSetValue() {
        System.out.println("Card.setValue() --");
        System.out.println("----------------------------------------");

        String newCard = "K";
        
        instance.setValue(newCard);
        String expResult = newCard;
        String result = instance.getValue();
        
        System.out.println("Old value:    " + card);
        System.out.println("New value:    " + newCard);
        System.out.println("Result value: " + result);        
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        System.out.println("Card.getSuit() --");
        System.out.println("----------------------------------------");

        
        String expResult = suit;
        String result = instance.getSuit();
        
        System.out.println("Old suit:    " + suit);
        System.out.println("Result suit: " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setSuit method, of class Card.
     */
    @Test
    public void testSetSuit() {
        System.out.println("Card.setSuit() --");
        System.out.println("----------------------------------------");

        String newSuit = "Diamonds";
        
        instance.setSuit(newSuit);
        String expResult = newSuit;
        String result = instance.getSuit();
        
        System.out.println("Old suit:    " + suit);
        System.out.println("New suit:    " + newSuit);
        System.out.println("Result suit: " + result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of returnCard method, of class Card.
     */
    @Test
    public void testReturnCard() {
        System.out.println("Card.returnCard() --");
        System.out.println("----------------------------------------");

        List<Card> result = instance.returnCard();
        List<Card> expResult = new ArrayList<>();
        expResult.add(new Card(card, suit));

        System.out.println("Expecting: " + expResult);
        System.out.println("Result:    " + result);
        
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        System.out.println("Card.toString() --");
        System.out.println("----------------------------------------");

        String expResult = "{\"value\":\"" + card + "\",\"suit\":\"" + suit + "\"}";
        String result = instance.toString();
        
        System.out.println("Expecting: " + expResult);
        System.out.println("Result:    " + result);
        
        assertEquals(expResult, result);
    }
    
}