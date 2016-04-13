/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author kepoly
 */
public class Game {

    /*
     *
     * Model the GAME table here
     * GAME META may need to extend this class.
     *
     */
    
    private String game_id;
    private int user_id;
    private String start_time;
    private String end_time;
    private int number_decks;
    private double user_starting_balance;
    private double user_bet_amount;

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getNumber_decks() {
        return number_decks;
    }

    public void setNumber_decks(int number_decks) {
        this.number_decks = number_decks;
    }

    public double getUser_starting_balance() {
        return user_starting_balance;
    }

    public void setUser_starting_balance(double user_starting_balance) {
        this.user_starting_balance = user_starting_balance;
    }

    public double getUser_bet_amount() {
        return user_bet_amount;
    }

    public void setUser_bet_amount(double user_bet_amount) {
        this.user_bet_amount = user_bet_amount;
    }
    
    public void insertNewGame() {
        
        java.sql.Connection conn;

     try {
        conn = Connection.getConnection();

        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO games (user_id, number_decks, user_starting_balance, game_code) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, user_id);
        pstmt.setInt(2, number_decks);
        pstmt.setDouble(3, user_starting_balance);
        pstmt.setString(4, game_id);
        pstmt.executeUpdate();
            ResultSet newId = pstmt.getGeneratedKeys();
            if (newId.next()) {
                
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        
    }
    
    public String returnGameJson(int g_id, int u_id, String start, String end, int decks, int starting_balance, int bet){
        return "{ \"game_id\" : \"" + g_id + "\", \"user_id\" : \"" + u_id + "\", \"start_time\" : \"" + start +
                "\", \"end_time\" : \"" + end + "\", \"number_decks\" : \"" + decks +
                "\", \"user_starting_balance\" : \"" + starting_balance + "\", \"user_bet_amount\" ; \"" + bet + "\" }";
    }
}
