/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import java.util.UUID;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 *
 * @author kepolyy
 */
@SessionScoped
public class Controller implements Serializable {
    
    private double minBet = 1;
    private double maxBet = 1000;
    private double balance = 1000;
    private double playerBet = minBet;
    private double defaultChips = 500;

    private double previousWin = 0;
    private String option = "";
    private Boolean hasPaidOut = false;

    private List finaldeck;

    private Hand player;
    private Hand dealer;

    private Boolean showDealerTotal = false;

    public Controller() {

    }

    public Controller(String name, Double balance) {

        List playerdummy = new ArrayList<>();
        List dealerdummy = new ArrayList<>();

        this.balance = balance;
        this.hasPaidOut = false;
        this.option = "newhand";
        this.player = new Hand(name, playerdummy);
        this.dealer = new Hand("Dealer", dealerdummy);

        Deck newdeck = new Deck();
        List ddeck = newdeck.getNewDeck();

        long seed = System.nanoTime();
        Collections.shuffle(ddeck, new Random(seed));
        this.finaldeck = ddeck;

        player.takeCardFromDeck(ddeck, 1);
        dealer.takeCardFromDeck(ddeck, 1);
        player.takeCardFromDeck(ddeck, 1);
        dealer.takeCardFromDeck(ddeck, 1);

    }

    public Boolean getShowDealerTotal() {
        return showDealerTotal;
    }

    public void setShowDealerTotal(Boolean showDealerTotal) {
        this.showDealerTotal = showDealerTotal;
    }

    public List getFinaldeck() {
        return finaldeck;
    }

    public void setFinaldeck(List finaldeck) {
        this.finaldeck = finaldeck;
    }

    public double getMinBet() {
        return minBet;
    }

    public void setMinBet(double minBet) {
        this.minBet = minBet;
    }

    public double getMaxBet() {
        return maxBet;
    }

    public void setMaxBet(double maxBet) {
        this.maxBet = maxBet;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public void removeBalance(double balance) {
        this.balance -= balance;
    }

    public double getPlayerBet() {
        return playerBet;
    }

    public void setPlayerBet(double playerBet) {
        if ("newhand".equals(this.getOption()) || "newhandDont".equalsIgnoreCase(this.getOption())) {
            if (playerBet > this.getBalance()) {
                playerBet = this.getBalance();
                this.setPlayerBet(playerBet);
            } else {
                this.playerBet = playerBet;
            }
        }
    }
    
    public void doubleDownPlayerBet() {
        this.playerBet = this.playerBet + this.playerBet;
    }

    public double getPreviousWin() {
        return previousWin;
    }

    public void setPreviousWin(double previousWin) {
        this.previousWin = previousWin;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Boolean getHasPaidOut() {
        return hasPaidOut;
    }

    public void setHasPaidOut(Boolean hasPaidOut) {
        this.hasPaidOut = hasPaidOut;
    }

    public Hand getPlayer() {
        return player;
    }

    public void setPlayer(Hand player) {
        this.player = player;
    }

    public Hand getDealer() {
        return dealer;
    }

    public void setDealer(Hand dealer) {
        this.dealer = dealer;
    }

    public Boolean checkCardAce(Card in) {
        Boolean returnVal = false;
        if (isNumber(in.value)) {
            int check = Integer.parseInt(in.value);
            if (check == 11) {
                returnVal = true;
            }
        } else {
            returnVal = false;
        }
        return returnVal;
    }

    public void getNewDeck() {
        Deck newdeck = new Deck();
        List gamedeck = newdeck.getNewDeck();
        long seed = System.nanoTime();
        Collections.shuffle(gamedeck, new Random(seed));
        this.setFinaldeck(gamedeck);
    }

    public double returnTotal(List hand, Boolean showTotal) {

        int handtotal = 0;
        int handaces = 0;

        for (int i = 0; i < hand.size(); i++) {
            Card check = (Card) hand.get(i);
            int value;
            if (isNumber(check.value)) {
                value = Integer.parseInt(check.value);
            } else {
                value = 10;
            }
            if (!showTotal && i == 1) {
                value = 0;
            }
            handtotal += value;
            if (this.checkCardAce(check)) {
                handaces += 1;
            }
            while (handtotal > 21 && handaces > 0) {
                handtotal -= 10;
                handaces--;
            }
        }
        return handtotal;
    }

    public String processGame(Double playerTotalInput, double dealerTotalInput, String checkOptionInput, Boolean hasPaidOutInput,
            Double playerBetInput, Double playerHandCountInput, Double dealerHandCountInput) {

        Double playerTotal = playerTotalInput;
        Double dealerTotal = dealerTotalInput;

        String checkOption = checkOptionInput;
        Boolean hasPaidOutCheck = hasPaidOutInput;

        Double playerBetCheck = playerBetInput;

        Double playerHandCount = playerHandCountInput;
        Double dealerHandCount = dealerHandCountInput;

        Double bjValue = (playerBetCheck * 1.5) + playerBetCheck;
        Double normalPay = playerBetCheck * 2;

        Double payoutValue = 0.0;

        Boolean checker = false;
        Boolean forceBetZero = false;

        String returnVal = "none";
        String returnValMsg = "Hit or Stand";
        
        String checkOptions = this.getOption();

        if ("newhand".equals(checkOption)) {
            checker = true;
        }

        if (checker || playerTotal >= 21.0 || dealerTotal >= 21.0) {
            checker = true;
            if (!hasPaidOutCheck) {
                if (playerTotal > 21) {
                    returnValMsg = "Player busts, start a new hand or rebet";
                    this.setHasPaidOut(true);
                    forceBetZero = true;
                } else if (dealerTotal > 21) {
                    returnValMsg = "Dealer busts, player wins";
                    this.setBalance(normalPay);
                    payoutValue = normalPay;
                    this.setHasPaidOut(true);
                } else if (playerTotal == 21 && dealerTotal != 21 && playerHandCount == 2) {
                    returnValMsg = "Player Blackjack x1.5 Bet";
                    this.setBalance(bjValue);
                    payoutValue = bjValue;
                    this.setHasPaidOut(true);
                } else if (dealerTotal == 21 && playerTotal != 21 && dealerHandCount == 2) {
                    returnValMsg = "Dealer Blackjack, Player loses";
                    this.setHasPaidOut(true);
                } else if (dealerTotal > playerTotal) {
                    returnValMsg = "Dealer Cards more than Players, Player loses";
                    this.setHasPaidOut(true);
                } else if (playerTotal > dealerTotal) {
                    returnValMsg = "Player Cards more than Dealers, Player wins";
                    this.setBalance(normalPay);
                    payoutValue = normalPay;
                    this.setHasPaidOut(true);
                } else if (Objects.equals(playerTotal, dealerTotal)) {
                    returnValMsg = "Player and Dealer Cards are Equal, Push";
                    this.setBalance(playerBetCheck);
                    payoutValue = playerBetCheck;
                    this.setHasPaidOut(true);
                }
            }
            this.setPreviousWin(payoutValue);
            this.setShowDealerTotal(true);
            
            if(this.balance == 0.0) {
                this.setPlayerBet(0.0);
            } else {
                this.setPlayerBet(playerBetCheck);
            }

          
            
            
            
            returnVal = "newhand";
            if (hasPaidOutCheck) {
                returnValMsg = "Hand over - Start a new hand or rebet";

            }
        } else if("newhandDont".equals(checkOptions)) {
            returnValMsg = "Please set your bet amount and deal";
            returnVal = "newhandDont";
        }
        this.setOption(returnVal);
        returnVal = "{" + "\"" + "handcheck" + "\":" + "\"" + returnVal + "\"" + "}";
        returnValMsg = "{" + "\"" + "message" + "\":" + "\"" + returnValMsg + "\"" + "}";
        List returnList = new ArrayList<>();
        returnList.add(returnVal);
        returnList.add(returnValMsg);
        String returnIt = returnList.toString();
        String finalRet = "{" + "\"" + "handcheck" + "\":" + returnIt + "}";
        return finalRet;
    }

    public void takeCardFromDeck(Boolean player) {
        if (player) {
            this.player.takeCardFromDeck(this.finaldeck, 1);
        } else {
            this.dealer.takeCardFromDeck(this.finaldeck, 1);
        }
    }

    public void resetChips() {
        this.setBalance(defaultChips);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         *IDK if this needs to be here..
         */
    }
}
