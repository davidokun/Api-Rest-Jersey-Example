package com.singletonapps.resources;

import com.singletonapps.model.Message;
import com.singletonapps.service.MessageService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/messages")
public class MessageResource {

    @Inject
    MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }

    @POST
    @Produces(MediaType.APPLICATION_XML)
    public Message addMessage(String body){

        throw new NotImplementedException();
    }
}
