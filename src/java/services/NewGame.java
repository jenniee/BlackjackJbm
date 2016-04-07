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
    @Path("/startNewHand")
    @Produces("application/json")
    public String startNewHand() {

        List ddeck = control.getFinaldeck();

        if (ddeck.size() < 10) {
            Deck newdeck = new Deck();
            ddeck = newdeck.getNewDeck();
        }

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

        String option = control.getOption();
        Double balance = control.getBalance();
        Double playerBet = control.getPlayerBet();
        Double newBet;

        if (option.equalsIgnoreCase("newhand")) {
            if (balance > 0) {
                if (playerBet > balance) {
                    control.setPlayerBet(balance);
                    newBet = balance;
                } else {
                    control.setPlayerBet(playerBet);
                    newBet = playerBet;
                }
                control.removeBalance(newBet);
            } else {
                control.setPlayerBet(0.0);
            }
        }

        control.setHasPaidOut(false);
        control.setShowDealerTotal(Boolean.FALSE);
        control.setOption("none");
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
        String returnString;
        returnString = "{" + "\"" + "total" + "\":" + "\"" + Double.toString(control.returnTotal(playerHand, Boolean.TRUE)) + "\"" + "}";
        return returnString;
    }

    @GET
    @Path("/getDealerTotal")
    @Produces("application/json")
    public String getDealerTotal() {
        Hand dealer = control.getDealer();
        List dealerHand = dealer.returnHandArray(Boolean.FALSE);
        Boolean check = control.getShowDealerTotal();
        String returnString;
        if (check) {
            returnString = Double.toString(control.returnTotal(dealerHand, Boolean.TRUE));
        } else {
            returnString = Double.toString(control.returnTotal(dealerHand, Boolean.FALSE));
        }
        returnString = "{" + "\"" + "total" + "\":" + "\"" + returnString + "\"" + "}";
        return returnString;
    }

    @GET
    @Path("/getPlayerHand")
    @Produces("application/json")
    public String getPlayerHand() {
        return control.getPlayer().toString();
    }

    @GET
    @Path("/getDealerHand")
    @Produces("application/json")
    public String getDealerHand() {
        Hand dealer = control.getDealer();
        List dealerHand = dealer.returnHandArray(Boolean.FALSE);
        int length = dealerHand.size();
        Double total = control.returnTotal(dealerHand, Boolean.TRUE);
        String option = control.getOption();
        if (length == 2 && total != 21 && !"newhand".equals(option)) {
            String json = "{" + "\"" + "value" + "\":" + "\"" + "back" + "\"" + ","
                    + "\"" + "suit" + "\":" + "\"" + "of_card" + "\""
                    + "}";
            dealerHand.set(1, json);
            String newHand = dealerHand.toString();
            String returnString = "{" + "\"" + "name" + "\":" + "\"" + "Dealer" + "\"" + ","
                    + "\"" + "hand" + "\":" + newHand
                    + "}";
            return returnString;
        }

        return control.getDealer().toString();
    }

    @GET
    @Path("/getPlayerBalance")
    @Produces("application/json")
    public String getPlayerBalance() {
        String returnString = "{" + "\"" + "balance" + "\":" + "\"" + Double.toString(control.getBalance()) + "\"" + "}";
        return returnString;
    }

    @GET
    @Path("/getPlayerBet")
    @Produces("application/json")
    public String getPlayerBet() {
        String returnString = "{" + "\"" + "bet" + "\":" + "\"" + Double.toString(control.getPlayerBet()) + "\"" + "}";
        return returnString;
    }

    @GET
    @Path("/returnOptions")
    @Produces("application/json")
    public String getOptions() {
        String returnString = "{" + "\"" + "option" + "\":" + "\"" + control.getOption() + "\"" + "}";
        return returnString;
    }

    @GET
    @Path("/getPreviousWin")
    @Produces("application/json")
    public String getPreviousWin() {
        String returnString = "{" + "\"" + "pwin" + "\":" + "\"" + Double.toString(control.getPreviousWin()) + "\"" + "}";
        return returnString;
    }

    @GET
    @Path("/setBetAmount")
    @Produces("application/json")
    public String setBetAmount(@QueryParam("betamount") Double input) {
        Double amount = input;
        control.setPlayerBet(amount);
        return "{" + "\"" + "msg" + "\":" + "\"" + "ok" + "\"" + "}";
    }

    @GET
    @Path("/getPlayerCard")
    @Produces("application/json")
    public String getPlayerCard() {
        List ddeck = control.getFinaldeck();
        control.getPlayer().takeCardFromDeck(ddeck, 1);
        
        return "{" + "\"" + "msg" + "\":" + "\"" + "ok" + "\"" + "}";
    }

    @GET
    @Path("/processGame")
    @Produces("application/json")
    public String processGame() {

        Hand player = control.getPlayer();
        List playerHand = player.returnHandArray(Boolean.TRUE);
        Double playerTotal = control.returnTotal(playerHand, Boolean.TRUE);

        Hand dealer = control.getDealer();
        List dealerHand = dealer.returnHandArray(Boolean.FALSE);
        Double dealerTotal = control.returnTotal(dealerHand, Boolean.TRUE);

        String checkOption = control.getOption();

        Boolean hasPaidOut = control.getHasPaidOut();

        Double playerBet = control.getPlayerBet();

        Double playerHandCount = (double) playerHand.size();

        Double dealerHandCount = (double) dealerHand.size();
        
        return control.processGame(playerTotal, dealerTotal, checkOption, hasPaidOut,
                playerBet, playerHandCount, dealerHandCount);
    }

    @GET
    @Path("/playerStand")
    @Produces("application/json")
    public String playerStand() {

        Hand player = control.getPlayer();
        List playerHand = player.returnHandArray(Boolean.TRUE);
        Double playerTotal = control.returnTotal(playerHand, Boolean.TRUE);

        Hand dealer = control.getDealer();
        List dealerHand = dealer.returnHandArray(Boolean.FALSE);
        Double dealerTotal = control.returnTotal(dealerHand, Boolean.TRUE);

        
        if (playerTotal < 22.0) {
            while (dealerTotal < 17.0) {
                List ddeck = control.getFinaldeck();
                System.out.println(ddeck);
                dealer.takeCardFromDeck(ddeck, 1);
                dealerTotal = control.returnTotal(dealer.returnHandArray(Boolean.FALSE), Boolean.TRUE);
            }
            control.setOption("newhand");
            control.setShowDealerTotal(Boolean.TRUE);
        }

        return "{" + "\"" + "msg" + "\":" + "\"" + "ok" + "\"" + "}";
    }
    
    @GET
    @Path("/resetChips")
    @Produces("application/json")
    public String resetChips() {
        control.resetChips();
        return "{" + "\"" + "msg" + "\":" + "\"" + "ok" + "\"" + "}";
    }
}