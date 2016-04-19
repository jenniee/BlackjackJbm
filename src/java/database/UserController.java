/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import java.sql.*;


/**
 *
 * @author bryner
 */
@SessionScoped
public class UserController implements Serializable {

    private List<User> users;
    private List<UserMeta> meta;

    /**
     *
     */
    public UserController() {
        updateUsersFromDatabase();
    }

    /**
     *
     * @return
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     *
     * @param id
     * @return
     */
    public String getUsernameById(int id) {
        this.updateUsersFromDatabase();
        for (User u : users) {
            if (u.getUser_id() == id) {
                return u.getUser_name();
            }
        }
        return null;
    }
    
    /**
     *
     * @param username
     * @return
     */
    public int returnUserIdFromDb(String username) {
        this.updateUsersFromDatabase();
        for (User u : users) {
            if (u.getUser_name().equals(username)) {
                System.out.println("checking");
                return u.getUser_id();
            }
        }
        return 0;
    }
    
    /**
     *
     * @param username
     * @return
     */
    public double returnUsersBalance(String username) {
        this.updateUsersFromDatabase();
        for (User u : users) {
            if (u.getUser_name().equals(username)) {
                System.out.println("checking balance");
                return u.getUser_balance();
            }
        }
        return 0;
    }
    
    /**
     *
     * @param username
     * @return
     */
    public String getUsernameByUsername(String username) {
        this.updateUsersFromDatabase();
        for (User u : users) {
            if (u.getUser_name() == null ? username == null : u.getUser_name().equals(username)) {
                return u.getUser_name();
            }
        }
        return null;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public int getUsernameByIdCheck(int id) {
        this.updateUsersFromDatabase();
        for (User u : users) {
            if (u.getUser_id() == id) {
                return u.getUser_id();
            }
        }
        return 0;
    }
    
    /**
     *
     * @param username
     * @return
     */
    public Boolean getUsernameByUsernameTrue(String username) {
        this.updateUsersFromDatabase();
        for(User u : users) {
            if(u.getUser_name().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     *
     * @param bet
     * @param username
     */
    public void removeFromBalance(double bet, String username) {
        java.sql.Connection conn;
        this.updateUsersFromDatabase();
        try {
            conn = Connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE USERS SET user_balance = user_balance - ? WHERE user_name = ?", Statement.RETURN_GENERATED_KEYS);
            pstmt.setDouble(1, bet);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
            ResultSet newId = pstmt.getGeneratedKeys();
            if (newId.next()) {
                
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param balance
     * @param username
     */
    public void setBalance(double balance, String username) {
        java.sql.Connection conn;
        this.updateUsersFromDatabase();
        try {
            conn = Connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE USERS SET user_balance = ? WHERE user_name = ?", Statement.RETURN_GENERATED_KEYS);
            pstmt.setDouble(1, balance);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
            ResultSet newId = pstmt.getGeneratedKeys();
            if (newId.next()) {
                
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param bet
     * @param username
     */
    public void addToBalance(double bet, String username) {
        java.sql.Connection conn;
        this.updateUsersFromDatabase();
        try {
            conn = Connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE USERS SET user_balance = user_balance + ? WHERE user_name = ?", Statement.RETURN_GENERATED_KEYS);
            pstmt.setDouble(1, bet);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
            ResultSet newId = pstmt.getGeneratedKeys();
            if (newId.next()) {
                
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param username
     */
    public void deleteUserFromDatabase(String username) {
        java.sql.Connection conn;
        this.updateUsersFromDatabase();
        try {
            conn = Connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM users WHERE user_name = ?", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, username);
            pstmt.executeUpdate();
            ResultSet newId = pstmt.getGeneratedKeys();
            if (newId.next()) {
                
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param username
     * @return
     */
    public List getPlayerMeta(String username) {
        meta = new ArrayList<>();
        java.sql.Connection conn;
        int playerId = this.returnUserIdFromDb(username);
        System.out.println("Getting meta with ID: " + username);
        this.updateUsersFromDatabase();
        try {
            conn = Connection.getConnection();
            String sql = "SELECT * FROM users_meta WHERE user_id = " + playerId;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                UserMeta u = new UserMeta(
                        rs.getInt("meta_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("total_bet"),
                        rs.getDouble("total_won"),
                        rs.getInt("total_hands"),
                        rs.getInt("hands_won"),
                        rs.getInt("blackjacks")
                );
                meta.add(u);
            }

            conn.close();
            return meta;
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return meta;
        }
    }

    private void updateUsersFromDatabase() {
        users = new ArrayList<>();
        java.sql.Connection conn;
        try {
            conn = Connection.getConnection();
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User u = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_hash_pass"),
                        rs.getDouble("user_balance")
                );
                users.add(u);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
