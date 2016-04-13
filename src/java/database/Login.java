/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
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

    public boolean getLoggedIn() {
                System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||");
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
}
