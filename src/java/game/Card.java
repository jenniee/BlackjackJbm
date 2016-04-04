/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author kepoly
 */
public class Card {
    
    public String value;
    public String suit;
    
    Card(String inValue, String inSuit)
    {
        this.value = inValue;
        this.suit = inSuit;
    }
    
    /**
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     * @return
     */
    public String getSuit() {
        return suit;
    }

    /**
     *
     * @param suit
     */
    public void setSuit(String suit) {
        this.suit = suit;
    } 
    
    public List returnCard() {
        List<Card> card = new ArrayList<>();
        card.add(new Card(getValue(), getSuit()));
        return card;
    }

    @Override
    public String toString() {
        return "{\"value\":\"" + value + "\",\"suit\":\"" + suit + "\"}";
    }
    
    
    
}
