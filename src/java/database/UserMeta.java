 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author kepoly
 */
public class UserMeta {

    /*
     *
     * Model the USER META table here
     * USER META may need to extend the User Class.
     *
     */
    public int meta_id;
    public int user_id;
    public int total_bet;
    public int total_won;
    public int total_hands;
    public int hands_won;
    public int blackjacks;

    public int getMeta_id() {
        return meta_id;
    }

    public void setMeta_id(int meta_id) {
        this.meta_id = meta_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTotal_bet() {
        return total_bet;
    }

    public void setTotal_bet(int total_bet) {
        this.total_bet = total_bet;
    }

    public int getTotal_won() {
        return total_won;
    }

    public void setTotal_won(int total_won) {
        this.total_won = total_won;
    }

    public int getTotal_hands() {
        return total_hands;
    }

    public void setTotal_hands(int total_hands) {
        this.total_hands = total_hands;
    }

    public int getHands_won() {
        return hands_won;
    }

    public void setHands_won(int hands_won) {
        this.hands_won = hands_won;
    }

    public int getBlackjacks() {
        return blackjacks;
    }

    public void setBlackjacks(int blackjacks) {
        this.blackjacks = blackjacks;
    }
    
    public String returnUserMetaJson(int m_id, int u_id, int bet, int won, int hands, int hands_won, int blackjacks){
        return "{ \"meta_id\" : \"" + m_id + "\", \"user_id\" : \"" + u_id + "\", \"total_bet\" : \"" + bet +
                "\", \"total_won\" : \"" + won + "\", \"total_hands\" : \"" + hands + "\", \"hands_won\" : \"" +
                hands_won + "\", \"blackjacks\" ; \"" + blackjacks + "\" }";
    }
}
