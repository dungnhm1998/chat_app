/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudm.da.nhom2.dashchat.api;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ltudm.da.nhom2.dashchat.ejb.TbluserFacade;
import ltudm.da.nhom2.dashchat.entity.Tblgroup;
import ltudm.da.nhom2.dashchat.entity.Tbluser;
import ltudm.da.nhom2.dashchat.entity.loginRequest;

/**
 * REST Web Service
 *
 * @author sangdz
 */
@Path("user")
public class UserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    @EJB
    TbluserFacade usercontroller;

    @POST
    @Path("addUser") // Thêm mới user
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(Tbluser request) {
        try {
            usercontroller.create(request);
            return Response.ok().status(201).build();
        } catch (WebApplicationException e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Path("login") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tbluser login(loginRequest request) {
        Tbluser u = null;
        try {
            u = usercontroller.findbyAccount(request.getAccount());
            if (u == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } catch (WebApplicationException e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
        if (u.getPassword() == null ? request.getPassword() == null : u.getPassword().equals(request.getPassword())) {
            return u;
        } else {
            return u=null;
        }
    }

    @GET
    @Path("getallUser")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tbluser> getAllUser() {
        List<Tbluser> userlist = null;
        try {
            userlist = usercontroller.findAll();
            if (userlist == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } catch (WebApplicationException ex) {

            throw new WebApplicationException(ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
        return userlist;
    }

    @GET
    @Path("getuserbyName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tbluser> getbyUserName(@PathParam("name") String userName) {
        try {
            List<Tbluser> t = usercontroller.findbyUserName(userName);
            if (t == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            } else {
                return t;
            }
        } catch (WebApplicationException e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GET
    @Path("getuserbyID/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tbluser getbyUserName(@PathParam("id") int id) {
        try {
                Tbluser t = usercontroller.find(id);
            if (t == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            } else {
                return t;
            }
        } catch (WebApplicationException e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
        @PUT
    @Path("updateUser/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int userid, Tbluser user) {
        try {
            Tbluser t = usercontroller.find(userid);
            if (t == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            } else {
                usercontroller.edit(user);
                return Response.ok().status(303).build();
            }
        } catch (WebApplicationException e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @DELETE
    @Path("deleteUser/{id}")
    public void deleteUser(@PathParam("id") int userid) {
        Tbluser t = usercontroller.find(userid);
        if (t == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } else {
            usercontroller.remove(t);
        }
    }
    
    
    
}
