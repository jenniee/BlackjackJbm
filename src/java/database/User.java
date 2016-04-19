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
 * @author kepoly
 */
@SessionScoped
public class User implements Serializable{

    /*
     *
     * Model the USER table here
     * USER META may need to extend this class.
     *
     */
    private int user_id;
    private String user_name;
    private String user_hash_pass;
    private double user_balance;
    private Boolean user_active;
    private int user_failed_log_attempts;

    /**
     *
     * @param user_id
     * @param user_name
     * @param user_hash_pass
     * @param user_balance
     */
    public User(int user_id, String user_name, String user_hash_pass, Double user_balance) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_hash_pass = user_hash_pass;
        this.user_balance = user_balance;
    }

    /**
     *
     * @return
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     *
     * @param user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     *
     * @return
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     *
     * @param user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     *
     * @return
     */
    public String getUser_hash_pass() {
        return user_hash_pass;
    }

    /**
     *
     * @param user_hash_pass
     */
    public void setUser_hash_pass(String user_hash_pass) {
        this.user_hash_pass = user_hash_pass;
    }

    /**
     *
     * @return
     */
    public double getUser_balance() {
        return user_balance;
    }

    /**
     *
     * @param user_balance
     */
    public void setUser_balance(double user_balance) {
        this.user_balance = user_balance;
    }

    /**
     *
     * @return
     */
    public Boolean getUser_active() {
        return user_active;
    }

    /**
     *
     * @param user_active
     */
    public void setUser_active(Boolean user_active) {
        this.user_active = user_active;
    }

    /**
     *
     * @return
     */
    public int getUser_failed_log_attempts() {
        return user_failed_log_attempts;
    }

    /**
     *
     * @param user_failed_log_attempts
     */
    public void setUser_failed_log_attempts(int user_failed_log_attempts) {
        this.user_failed_log_attempts = user_failed_log_attempts;
    }
    
    /**
     *
     * @param id
     * @param name
     * @param hash
     * @param balance
     * @param active
     * @param failed_attempts
     * @return
     */
    public String returnJson(int id, String name, String hash, int balance, Boolean active, int failed_attempts){
        return "{ \"user_id\" : \"" + id + "\", \"user_name\" : \"" + name + "\", user_hash_pass : \"" + hash +
                "\", \"user_balance\" : \"" + balance+ "\", \"user_active\" : \"" + active +
                "\", \"user_failed_log_attempts\" : \"" + failed_attempts + "\" }";
    }
}