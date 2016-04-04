/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import game.*;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Jenniee
 */
@Path("/newGame")
@SessionScoped
public class NewGame implements Serializable {
    
    @Inject
    Controller control;
    
    @GET
    @Produces("application/json")
        /*
        * This will be a void method
        * for testing puroposes we are returning some data.
        */
    public String newGame() {
        
        /*
        * We would like the be able to initialize the below functions
        * in the controller class(noproblem) but then persist the instance in the
        * users session so refreshing the page doesn't start a new game.
        */

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
        
        control.setDealer(dealer);
        control.setPlayer(player);
        return player.toString();
       
    }
    
    @GET
    @Path("/current")
    @Produces("application/json")
    public String getCurrent() {
        return control.getPlayer().toString();
    }
    
    
}
