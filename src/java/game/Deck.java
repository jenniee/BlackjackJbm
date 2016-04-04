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
public class Deck {
    
    private List<Card> clubs = new ArrayList<>();
    private List<Card> diamonds = new ArrayList<>();
    private List<Card> hearts = new ArrayList<>();
    private List<Card> spades = new ArrayList<>();
    
    Deck() {
        this.clubs = new Suit("Clubs").buildSuits();
        this.diamonds = new Suit("Diamonds").buildSuits();
        this.hearts = new Suit("Hearts").buildSuits();
        this.spades = new Suit("Spades").buildSuits();
    }

    
    public List getNewDeck() {
        List<Card> deck = new ArrayList<>();
        deck.addAll(clubs);
        deck.addAll(diamonds);
        deck.addAll(hearts);
        deck.addAll(spades);
        return deck;
    }
    
}


