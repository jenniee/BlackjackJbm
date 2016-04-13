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
        for (User u: users) {
            if (u.getUser_id() == id) {
                return u.getUser_name();
            }
        }
        return null;
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
                    rs.getString("user_hash_pass")
                );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
