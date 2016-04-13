/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c0647063
 */
public class Connection {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(java.sql.Connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        String hostname = "localhost";
        String port = "3306";
        String dbname = "blackjack";
        String username = "root";
        String password = "";
        String jdbc = String.format("jdbc:mysql://%s:%s/%s", hostname, port, dbname);
        return (Connection) DriverManager.getConnection(jdbc, username, password);
    }
}
