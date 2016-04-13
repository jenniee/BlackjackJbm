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
public class User {

    /*
     *
     * Model the USER table here
     * USER META may need to extend this class.
     *
     */
    public int user_id;
    public String user_name;
    public String user_hash_pass;
    public int user_balance;
    public Boolean user_active;
    public int user_failed_log_attempts;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_hash_pass() {
        return user_hash_pass;
    }

    public void setUser_hash_pass(String user_hash_pass) {
        this.user_hash_pass = user_hash_pass;
    }

    public int getUser_balance() {
        return user_balance;
    }

    public void setUser_balance(int user_balance) {
        this.user_balance = user_balance;
    }

    public Boolean getUser_active() {
        return user_active;
    }

    public void setUser_active(Boolean user_active) {
        this.user_active = user_active;
    }

    public int getUser_failed_log_attempts() {
        return user_failed_log_attempts;
    }

    public void setUser_failed_log_attempts(int user_failed_log_attempts) {
        this.user_failed_log_attempts = user_failed_log_attempts;
    }
    
    public String returnJson(int id, String name, String hash, int balance, Boolean active, int failed_attempts){
        return "{ \"user_id\" : \"" + id + "\", \"user_name\" : \"" + name + "\", user_hash_pass : \"" + hash +
                "\", \"user_balance\" : \"" + balance+ "\", \"user_active\" : \"" + active +
                "\", \"user_failed_log_attempts\" : \"" + failed_attempts + "\" }";
    }
}
