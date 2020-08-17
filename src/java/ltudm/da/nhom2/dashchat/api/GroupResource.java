/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudm.da.nhom2.dashchat.api;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ltudm.da.nhom2.dashchat.ejb.TblgroupFacade;
import ltudm.da.nhom2.dashchat.ejb.TblgroupuserFacade;
import ltudm.da.nhom2.dashchat.entity.Tblgroup;
import ltudm.da.nhom2.dashchat.entity.Tblgroupuser;
import ltudm.da.nhom2.dashchat.entity.Tbluser;

/**
 * REST Web Service
 *
 * @author sangdz
 */
@Path("group")
public class GroupResource {

    @Context
    private UriInfo context;
    public GroupResource() {
    }
    
    @EJB
    TblgroupFacade groupcontroller;
    @EJB
    TblgroupuserFacade groupusercontroller;
    
    @POST
    @Path("addGroup")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGroup(Tblgroup request) {
        
        try {
            groupcontroller.create(request);
            return Response.ok().status(201).build();
        } catch (WebApplicationException e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GET
    @Path("getallGroup")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tblgroup> getAllGroup() {
        List<Tblgroup> grouplist = null;
        try {
            grouplist = groupcontroller.findAll();
            if (grouplist == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } catch (WebApplicationException ex) {
           
            throw new WebApplicationException(ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
        return grouplist;
    }
    
    @GET
    @Path("findGroupByID/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tblgroup> findGroupByID(@PathParam("id") int id) {
        try {
            List<Tblgroupuser> t = groupusercontroller.findGroupByID(id);

            if (t == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            } else {
                List<Tblgroup> response = new ArrayList<>();
                for (Tblgroupuser t1 : t) {
                    //System.out.println("OKconbo");
                    System.out.println(t1.getTblgroupuserPK().getGroupID());
                    try {
                        Tblgroup element = groupcontroller.find(t1.getTblgroupuserPK().getGroupID());
                        response.add(element);
                    } catch (Exception e) {
                        System.out.println("day la null");
                    }
                }
                return response;
            }
        } catch (WebApplicationException e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GET
    @Path("getgroupbyID/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tblgroup getgroupbyID(@PathParam("id") int id) {
        try {
                Tblgroup t = groupcontroller.findgroupbyID(id);
            if (t == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            } else {
                return t;
            }
        } catch (WebApplicationException e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
