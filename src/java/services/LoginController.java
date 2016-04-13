/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.Login;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author bryner
 */
@Path("/login")
@SessionScoped
public class LoginController implements Serializable {
    
    @Inject
    Login user;
    
    @GET
    @Path("/doLogin")
    @Produces("application/json")
    public Response doLogin() {
        user.setLoggedIn(Boolean.TRUE);
        return Response.ok("Ok").build();
    }
    
    @GET
    @Path("/getLoggedIn")
    @Produces("application/json")
    public Response getLoggedIn() {
        System.out.println(user.getLoggedIn());
        return Response.ok("OK").build();
    }
    
    @GET
    @Path("/show")
    @Produces("application/json")
    public Response showLoggedIn() {
        this.doLogin();
        String res = "{ \"loggedIn\":  " + user.getLoggedIn() +  "}";
        return Response.ok(res).build();
    }
}
