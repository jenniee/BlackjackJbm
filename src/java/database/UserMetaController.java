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
public class UserMetaController implements Serializable {
    
    UserController user = new UserController();
    
    public void addToTotalCredits() {
        
    }
    
}
