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
import javax.ws.rs.QueryParam;
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
    public String newGame() {
        return "{\"response\": \"ok\"}";
    }
   
    
    @GET
    @Path("/startNewGame")
    @Produces("application/json")
    public String startNewGame() {
                
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
        control.setFinaldeck(ddeck);

        return "{\"response\": \"ok\"}";
    }
    
    
    @GET
    @Path("/getPlayerTotal")
    @Produces("application/json")
    public String getPlayerTotal() {
        Hand player = control.getPlayer();
        List playerHand = player.returnHandArray(Boolean.TRUE);
        return Double.toString(control.returnTotal(playerHand, Boolean.TRUE));
    }

    @GET
    @Path("/getDealerTotal")
    @Produces("application/json")
    public String getDealerTotal() {
        Hand dealer = control.getDealer();
        List dealerHand = dealer.returnHandArray(Boolean.FALSE);
        return Double.toString(control.returnTotal(dealerHand, Boolean.FALSE));
    }

    @GET
    @Path("getPlayerHand")
    @Produces("application/json")
    public String getPlayerHand() {
        return control.getPlayer().toString();
    }

    @GET
    @Path("getDealerHand")
    @Produces("application/json")
    public String getDealerHand() {
        return control.getDealer().toString();
    }

    @GET
    @Path("getPlayerBalance")
    @Produces("application/json")
    public String getPlayerBalance() {
        return Double.toString(control.getBalance());
    }

    @GET
    @Path("getPlayerBet")
    @Produces("application/json")
    public String getPlayerBet() {
        return Double.toString(control.getPlayerBet());
    }

    @GET
    @Path("returnOptions")
    @Produces("application/json")
    public String getOptions() {
        return control.getOption();
    }

    @GET
    @Path("getPreviousWin")
    @Produces("application/json")
    public String getPreviousWin() {
        return Double.toString(control.getPreviousWin());
    }

    @GET
    @Path("setBetAmount")
    @Produces("application/json")
    public void setBetAmount(@QueryParam("betamount") Double input) {
        Double amount = input;
        control.setPlayerBet(amount);
    }
    
    @GET
    @Path("getPlayerCard")
    @Produces("application/json")
    public void getPlayerCard() {
        List ddeck = control.getFinaldeck();
        control.getPlayer().takeCardFromDeck(ddeck, 1);
    }
    
    @GET
    @Path("processGame")
    @Produces("application/json")
    public void processGame() {
        
        Hand player = control.getPlayer();
        List playerHand = player.returnHandArray(Boolean.TRUE);
        Double playerTotal = control.returnTotal(playerHand, Boolean.TRUE);
        
        Hand dealer = control.getDealer();
        List dealerHand = dealer.returnHandArray(Boolean.FALSE);
        Double dealerTotal = control.returnTotal(dealerHand, Boolean.FALSE);
        
        String checkOption = control.getOption();
        
        Boolean hasPaidOut = control.getHasPaidOut();
        
        Double playerBet = control.getPlayerBet();
        
        Double playerHandCount = (double) playerHand.size();
        
        Double dealerHandCount = (double) dealerHand.size();
        
        control.processGame(playerTotal, dealerTotal, checkOption, hasPaidOut,
                playerBet, playerHandCount, dealerHandCount);
    }

}
