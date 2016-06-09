package com.singletonapps.resources;

import com.singletonapps.model.Message;
import com.singletonapps.service.MessageService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/messages")
public class MessageResource {

    @Inject
    MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId){
        return messageService.getMessage(messageId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(String body){

        throw new NotImplementedException();
    }
}
