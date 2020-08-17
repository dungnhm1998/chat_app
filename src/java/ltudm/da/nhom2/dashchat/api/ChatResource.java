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
import ltudm.da.nhom2.dashchat.ejb.TblchatFacade;
import ltudm.da.nhom2.dashchat.entity.IDchat;
import ltudm.da.nhom2.dashchat.entity.ShowLastMessageResponse;
import ltudm.da.nhom2.dashchat.entity.Tblchat;
import ltudm.da.nhom2.dashchat.entity.Tbluser;

/**
 * REST Web Service
 *
 * @author sangdz
 */
@Path("chat")
public class ChatResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ChatResource
     */
    public ChatResource() {
    }

    @EJB
    TblchatFacade chatcontroller;

    @POST
    @Path("addChat") // Them mot tin nhan vao tblChat
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addChat(Tblchat request) {
        try {
            chatcontroller.create(request);
            return Response.ok().status(201).build();
        } catch (WebApplicationException e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Path("addChat2") // Them mot tin nhan vao tblChat
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addChat2(Tblchat request) {
        try {
            chatcontroller.create(request);
            return "OK";
        } catch (WebApplicationException e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Path("getinfochat") // Lấy lịch sử chat của ID1 với ID2, type = u/g 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tblchat> getchatbyID(IDchat IDchat) {
        try {
            List<Tblchat> t = chatcontroller.findchatbyID(IDchat.getID1(), IDchat.getID2(), IDchat.getType());
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
    @Path("getLastMessage/{id}") // Lấy tin nhắn cuối của ID1 với mọi người type = u/g 
    @Produces(MediaType.APPLICATION_JSON)
    public ShowLastMessageResponse getLastMessage(@PathParam("id") int id) {
        try {
            List<Tblchat> t = chatcontroller.findMessageByID(id);
            if (t == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            } else {
                ShowLastMessageResponse response1 = new ShowLastMessageResponse();
                for (Tblchat t1 : t) {
                    ShowLastMessageResponse element = new ShowLastMessageResponse(t1.getSender(), t1.getReceiver(), t1.getContent(), t1.getType());
                    response1 = element;
                }
                return response1;
            }
        } catch (WebApplicationException e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    // tra ve danh sach user, group da chat
    @GET
    @Path("getChatID/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tblchat> getAllLastMessage(@PathParam("id") int id) {
        try {
            List<Tblchat> t = chatcontroller.findchatID(id);
            if (t == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            } else {
                List<Tblchat> response = new ArrayList<Tblchat>();
                Integer matrixUser[][] = new Integer[100][100];
                Integer arrayUser[] = new Integer[100];
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        matrixUser[i][j] = 0;
                    }
                    arrayUser[i]=0;
                }
                
                for (Tblchat t1 : t) {
                    if (t1.getType().equals("u")) {
                        matrixUser[t1.getSender()][t1.getReceiver()] = 1;
                    } else if (t1.getType().equals("g")) {
                        arrayUser[t1.getReceiver()] = 1;
                    }
                }
                for (Tblchat t1 : t) {
                    if (matrixUser[t1.getSender()][t1.getReceiver()] == 1) {
                        matrixUser[t1.getSender()][t1.getReceiver()] = 0;
                        matrixUser[t1.getReceiver()][t1.getSender()] = 0;
                        response.add(t1);
                    } else if (arrayUser[t1.getReceiver()] == 1) {
                        arrayUser[t1.getReceiver()] = 0;
                        response.add(t1);
                    }
                }
                return response;
            }
        } catch (WebApplicationException e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}
