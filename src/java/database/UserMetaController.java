/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author kepoly
 */
@SessionScoped
public class UserMetaController implements Serializable {
    
    UserController user = new UserController();
    
    public void addToTotalCredits(String username, Double bet) {
        UserController userControl = new UserController();
                java.sql.Connection conn;
        int playerId = userControl.returnUserIdFromDb(username);
        try {
            conn = Connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE users_meta SET total_won = total_won + ? WHERE user_id = ?", Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setDouble(1, bet);
            pstmt.setInt(2, playerId);

            pstmt.executeUpdate();
            ResultSet newId = pstmt.getGeneratedKeys();
            if (newId.next()) {
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        public void addToTotalBet(String username, Double bet) {
        UserController userControl = new UserController();
                java.sql.Connection conn;
        int playerId = userControl.returnUserIdFromDb(username);
        try {
            conn = Connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE users_meta SET total_bet = total_bet + ? WHERE user_id = ?", Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setDouble(1, bet);
            pstmt.setInt(2, playerId);

            pstmt.executeUpdate();
            ResultSet newId = pstmt.getGeneratedKeys();
            if (newId.next()) {
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    public void addToTotalHands(String username) {
        UserController userControl = new UserController();
                java.sql.Connection conn;
        int playerId = userControl.returnUserIdFromDb(username);
        try {
            conn = Connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE users_meta SET total_hands = total_hands + 1 WHERE user_id = ?", Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, playerId);

            pstmt.executeUpdate();
            ResultSet newId = pstmt.getGeneratedKeys();
            if (newId.next()) {
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
