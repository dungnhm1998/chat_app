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

/**
 * REST Web Service
 *
 * @author Admin
 */
@Path("groupuser")
public class GroupuserResource {

    @Context
    private UriInfo context;

    public GroupuserResource() {
    }
    @EJB
    TblgroupuserFacade groupusercontroller;
    TblgroupFacade groupcontroller;

    
}
