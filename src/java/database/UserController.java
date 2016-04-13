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

    public UserController() {
        updateUsersFromDatabase();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getUsernameById(int id) {
        this.updateUsersFromDatabase();
        for (User u : users) {
            if (u.getUser_id() == id) {
                return u.getUser_name();
            }
        }
        return null;
    }
    
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
    
    public String getUsernameByUsername(String username) {
        this.updateUsersFromDatabase();
        for (User u : users) {
            if (u.getUser_name() == null ? username == null : u.getUser_name().equals(username)) {
                return u.getUser_name();
            }
        }
        return null;
    }
    
    public int getUsernameByIdCheck(int id) {
        this.updateUsersFromDatabase();
        for (User u : users) {
            if (u.getUser_id() == id) {
                return u.getUser_id();
            }
        }
        return 0;
    }
    
    public Boolean getUsernameByUsernameTrue(String username) {
        this.updateUsersFromDatabase();
        for(User u : users) {
            if(u.getUser_name().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
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
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
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
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
