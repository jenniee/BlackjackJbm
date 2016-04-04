/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import game.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Jenniee
 */
@Path("/newGame")
@SessionScoped
@ManagedBean(name="game")
public class NewGame {
    
    @GET
    @Produces("application/json")
    public String newGame() {

        Controller control = new Controller();
        Deck newdeck = new Deck();
        List ddeck = newdeck.getNewDeck();

        long seed = System.nanoTime();
        Collections.shuffle(ddeck, new Random(seed));

        List playerdummy = new ArrayList<>();
        List dealerdummy = new ArrayList<>();

        Hand player = new Hand("Player", playerdummy);
        Hand dealer = new Hand("Dealer", dealerdummy);

        player.takeCardFromDeck(ddeck, 1);
        dealer.takeCardFromDeck(ddeck, 1);
        player.takeCardFromDeck(ddeck, 1);
        dealer.takeCardFromDeck(ddeck, 1);

        List playerHand = player.returnHandArray(Boolean.TRUE);
        List dealerHand = dealer.returnHandArray(Boolean.FALSE);
        System.out.println(playerHand);
        System.out.println(player.toString());
        System.out.println("--------------");
        System.out.println(dealerHand);
        System.out.println(dealer.toString());
        System.out.println("--------------");
        System.out.println(ddeck);
        System.out.println("--------------");
        System.out.println(control.returnTotal(playerHand, Boolean.TRUE));
        System.out.println(control.returnTotal(dealerHand, Boolean.FALSE));
        
        return player.toString();
       
    }
}
