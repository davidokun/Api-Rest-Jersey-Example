package com.singletonapps.endpoints;

import com.singletonapps.model.Message;
import com.singletonapps.service.MessageService;
import com.singletonapps.util.HateoasResourceHelper;
import com.singletonapps.util.LinkType;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;


@Path("/messages")
public class MessageController {

    @Inject
    private MessageService messageService;

    @Inject
    private CommentController commentController;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages(@QueryParam("year") int year,
                                @QueryParam("offset") int offset,
                                @QueryParam("size") int size){

        GenericEntity<List<Message>> entity;

        if (year > 0){

            entity = new GenericEntity<List<Message>>(messageService.getAllMessagesByYear(year)){};
            return Response.ok(entity)
                    .build();
        }

        if (offset >= 0 && size > 0){
            entity = new GenericEntity<List<Message>>(messageService.getAllMessagesPaginated(offset, size)){};
            return Response.ok(entity)
                    .build();
        }

        entity = new GenericEntity<List<Message>>(messageService.getAllMessages()){};
        return Response.ok(entity)
                .build();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo){

        final Message message = messageService.getMessage(messageId);

        addMessageLinks(uriInfo, message);

        return Response.ok(message)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMessage(Message message, @Context UriInfo uriInfo){

        Message responseMessage = messageService.addMessage(message);
        String newId = String.valueOf(responseMessage.getId());

        return Response.created(uriInfo.getAbsolutePathBuilder().path(newId).build())
                    .entity(responseMessage)
                    .build();
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMessage(@PathParam("messageId") long id, Message message){

        message.setId(id);

        return Response.ok(messageService.updateMessage(message))
                .build();
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeMessage(@PathParam("messageId") long id){

        messageService.removeMessage(id);

        return Response.noContent()
                .build();
    }


    @Path("/{messageId}/comments")
    public CommentController getCommentController(){

        return commentController;
    }


    private void addMessageLinks(@Context UriInfo uriInfo, Message message) {
        message.addLink(HateoasResourceHelper.getUriForSelf(uriInfo),
                LinkType.SELF.getType());
        message.addLink(HateoasResourceHelper.getUriForAuthor(uriInfo, message),
                LinkType.AUTHOR.getType());
        message.addLink(HateoasResourceHelper.getUriForComments(uriInfo, message),
                LinkType.COMMENTS.getType());
    }

}
