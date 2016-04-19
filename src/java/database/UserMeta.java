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

    /**
     *
     */
    
    public int meta_id;

    /**
     *
     */
    public int user_id;

    /**
     *
     */
    public double total_bet;

    /**
     *
     */
    public double total_won;

    /**
     *
     */
    public int total_hands;

    /**
     *
     */
    public int hands_won;

    /**
     *
     */
    public int blackjacks;

    /**
     *
     * @param meta_id
     * @param user_id
     * @param total_bet
     * @param total_won
     * @param total_hands
     * @param hands_won
     * @param blackjacks
     */
    public UserMeta(int meta_id, int user_id, double total_bet, double total_won, int total_hands, int hands_won, int blackjacks) {
        this.meta_id = meta_id;
        this.user_id = user_id;
        this.total_bet = total_bet;
        this.total_won = total_won;
        this.total_hands = total_hands;
        this.hands_won = hands_won;
        this.blackjacks = blackjacks;
    }

    /**
     *
     */
    public UserMeta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     *
     * @return
     */
    public int getMeta_id() {
        return meta_id;
    }

    /**
     *
     * @param meta_id
     */
    public void setMeta_id(int meta_id) {
        this.meta_id = meta_id;
    }

    /**
     *
     * @return
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     *
     * @param user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     *
     * @return
     */
    public double getTotal_bet() {
        return total_bet;
    }

    /**
     *
     * @param total_bet
     */
    public void setTotal_bet(double total_bet) {
        this.total_bet = total_bet;
    }

    /**
     *
     * @return
     */
    public double getTotal_won() {
        return total_won;
    }

    /**
     *
     * @param total_won
     */
    public void setTotal_won(double total_won) {
        this.total_won = total_won;
    }

    /**
     *
     * @return
     */
    public int getTotal_hands() {
        return total_hands;
    }

    /**
     *
     * @param total_hands
     */
    public void setTotal_hands(int total_hands) {
        this.total_hands = total_hands;
    }

    /**
     *
     * @return
     */
    public int getHands_won() {
        return hands_won;
    }

    /**
     *
     * @param hands_won
     */
    public void setHands_won(int hands_won) {
        this.hands_won = hands_won;
    }

    /**
     *
     * @return
     */
    public int getBlackjacks() {
        return blackjacks;
    }

    /**
     *
     * @param blackjacks
     */
    public void setBlackjacks(int blackjacks) {
        this.blackjacks = blackjacks;
    }
    
    /**
     *
     * @param m_id
     * @param u_id
     * @param bet
     * @param won
     * @param hands
     * @param hands_won
     * @param blackjacks
     * @return
     */
    public String returnUserMetaJson(int m_id, int u_id, int bet, int won, int hands, int hands_won, int blackjacks){
        return "{ \"meta_id\" : \"" + m_id + "\", \"user_id\" : \"" + u_id + "\", \"total_bet\" : \"" + bet +
                "\", \"total_won\" : \"" + won + "\", \"total_hands\" : \"" + hands + "\", \"hands_won\" : \"" +
                hands_won + "\", \"blackjacks\" ; \"" + blackjacks + "\" }";
    }
    
    
    
}
