package com.singletonapps.endpoints;

import com.singletonapps.model.Message;
import com.singletonapps.service.MessageService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/messages")
public class MessageController {

    @Inject
    private MessageService messageService;

    @Inject
    private CommentController commentController;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(@QueryParam("year") int year,
                                     @QueryParam("offset") int offset,
                                     @QueryParam("size") int size){

        if (year > 0){
            return messageService.getAllMessagesByYear(year);
        }

        if (offset >= 0 && size > 0){
            return messageService.getAllMessagesPaginated(offset, size);
        }

        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId){

        return messageService.getMessage(messageId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message){

        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long id, Message message){

        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void removeMessage(@PathParam("messageId") long id){

        messageService.removeMessage(id);
    }


    @Path("/{messageId}/comments")
    public CommentController getCommentController(){

        return commentController;
    }
}
