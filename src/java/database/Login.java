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
 * @author bryner
 */
@SessionScoped
public class Login implements Serializable{
    private String username;
    private String password;
    private Boolean loggedIn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public boolean doLogin() {
        String passhash = Hash.hash(password);
        loggedIn = false;
        for (User u : new UserController().getUsers()) {
            if (username.equals(u.getUser_name()) 
                    && passhash.equals(u.getUser_hash_pass())) {
                loggedIn = true;
            }
        }
        return loggedIn;
    }
    
    public Boolean registerNewUser(String username, String password) {

        java.sql.Connection conn;
        int checker;
        if(username.length() < 4 || password.length() < 4) {
            return false;
        } else if("undefined".equals(username) || "undefined".equals(password)) {
            return false;
        } else if(new UserController().getUsernameByUsernameTrue(username)) {
            return false;
        }
        try {
        conn = Connection.getConnection();
        String hashedPassword = Hash.hash(password);
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (user_name, user_hash_pass, user_balance, user_active, user_failed_log_attempts) VALUES(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, username);
        pstmt.setString(2, hashedPassword);
        pstmt.setInt(3, 1000);
        pstmt.setInt(4, 1);
        pstmt.setInt(5, 0);
        pstmt.executeUpdate();
            ResultSet newId = pstmt.getGeneratedKeys();
            if (newId.next()) {
                checker = newId.getInt(1);
                if(checker > 0) {   
                    PreparedStatement pstmt2 = conn.prepareStatement("INSERT INTO users_meta (user_id) VALUES (?)");
                    pstmt2.setInt(1, checker);
                    pstmt2.executeUpdate();              
                    return true;
                }
            } else {
                return false;
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
    
    
}
