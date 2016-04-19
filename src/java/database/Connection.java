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

    /**
     *
     * @return
     * @throws SQLException
     */
    public static java.sql.Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String host = "localhost";
            String port = "3306";
            String db = "blackjackjbm";
            String user = "root";
            String pass = "";
            String jdbc = "jdbc:mysql://" + host + ":" + port + "/" + db;
            return DriverManager.getConnection(jdbc, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
