/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kepoly
 */
public class Suit {

    /**
     *
     */
    public String suitName;
    
    /**
     *
     * @param inSuitName
     */
    public Suit(String inSuitName)
    {
        this.suitName = inSuitName;
    }
    
    /**
     *
     * @return
     */
    public List buildSuits() {
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i <= 9; i++) {
            String card = Integer.toString(i + 2);
            cards.add(new Card(card, this.suitName)); 
        }
        cards.add(new Card("J", this.suitName));
        cards.add(new Card("Q", this.suitName));
        cards.add(new Card("K", this.suitName));
        return cards;
    }

    @Override
    public String toString() {
        return "{" + "\"" + "suitName" + "\":" + "\"" + suitName + "\"" + '}';
    }
    
    
    
    
}
