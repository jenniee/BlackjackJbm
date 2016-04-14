/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.Login;
import database.UserController;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.json.JSONArray;



/**
 *
 * @author bryner
 */

@Path("/login")
@SessionScoped
public class LoginRest implements Serializable {
    
    @Inject
    Login user;
    
    @GET
    @Path("/doLogin")
    @Produces("application/json")
    public Response doLogin() {
        
        return Response.ok("{ \"loggedIn\":  " + true +  "}").build();
    }
    
    @GET
    @Path("/getLoggedIn")
    @Produces("application/json")
    public Response getLoggedIn() {
        return Response.ok("{ \"loggedIn\":  " + user.getLoggedIn() +  ", \"username\": " + "\"" + user.getUsername() + "\"" + " }").build();
    }
    
    @GET
    @Path("/getUserBalance")
    @Produces("application/json")
    public Response getUserBalance(@QueryParam("username") String username) {
        UserController userControl = new UserController();
        Double retDouble = userControl.returnUsersBalance(username);
        return Response.ok("{ \"balance\":  " + retDouble +  "}").build();
    }
    
    @GET
    @Path("/getUserParams")
    @Produces("application/json")
    public Response getUserParams(@QueryParam("username") String username) {
        UserController userControl = new UserController();
        JSONArray json = new JSONArray(userControl.getPlayerMeta(username));
        System.out.println("LoginControl user: " + json);
        return Response.ok("{ \"meta\":  " + json + " }").build();
    }
    
    @GET
    @Path("/deleteAccount")
    @Produces("application/json")
    public Response deleteUser(@QueryParam("username") String username) {
        UserController userControl = new UserController();
        userControl.deleteUserFromDatabase(username);
        user.setLoggedIn(Boolean.FALSE);
        return Response.ok("{ \"diddelete\":  " + user.getLoggedIn() + "}").build();
    }
    
    @GET
    @Path("/registerNewUser")
    @Produces("application/json")
    public Response registerNewUser(@QueryParam("username") String username, @QueryParam("password") String password) {
        
        Boolean didRegister = user.registerNewUser(username, password);
        if(didRegister == true) {
            return Response.ok("{ \"registered\":  " + true +  "}").build();
        } else {
            return Response.ok("{ \"registered\":  " + false +  "}").build();
        }
    }
    
    @GET
    @Path("/loginWithParams")
    @Produces("application/json")
    public Response loginWithParams(@QueryParam("username") String username, @QueryParam("password") String password) {
        user.setPassword(password);
        user.setUsername(username);
        Boolean didLogin = user.doLogin();
        if(didLogin == true) {
            user.setLoggedIn(Boolean.TRUE);
            user.setUsername(username);
            return Response.ok("{ \"loggedIn\":  " + true +  "}").build();
        } else {
            user.setLoggedIn(Boolean.FALSE);
            return Response.ok("{ \"loggedIn\":  " + false +  "}").build();
        }
    }
    
    @GET
    @Path("/show")
    @Produces("application/json")
    public Response showLoggedIn() {
        String res;
        if(user.getLoggedIn() == null) {
            res = "{ \"loggedIn\":  " + false +  "}"; 
        } else {
            res = "{ \"loggedIn\":  " + user.getLoggedIn() +  "}";
        }
        return Response.ok(res).build();
    }
}
