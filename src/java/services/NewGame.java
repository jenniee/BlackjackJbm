/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.faces.bean.SessionScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Jenniee
 */
@Path("/newGame")
@SessionScoped
public class NewGame {
    
    @GET
    @Produces("application/json")
    public void newGame() {
       
       
    }
}
