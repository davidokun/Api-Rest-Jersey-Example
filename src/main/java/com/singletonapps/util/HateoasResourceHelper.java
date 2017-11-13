package com.singletonapps.util;

import com.singletonapps.endpoints.CommentController;
import com.singletonapps.endpoints.MessageController;
import com.singletonapps.endpoints.ProfileController;
import com.singletonapps.model.Message;

import javax.ws.rs.core.UriInfo;

public class HateoasResourceHelper {

    public static String getUriForSelf(UriInfo uriInfo) {
        return uriInfo.getAbsolutePathBuilder()
                .build()
                .toString();
    }

    public static String getUriForAuthor(UriInfo uriInfo, Message message) {

        return uriInfo.getBaseUriBuilder()
                .path(ProfileController.class)
                .path(message.getAuthor())
                .build()
                .toString();

    }

    public static String getUriForComments(UriInfo uriInfo, Message message) {

        return uriInfo.getBaseUriBuilder()
                .path(MessageController.class)
                .path(MessageController.class, "getCommentController")
                .path(CommentController.class)
                .resolveTemplate("messageId", message.getId())
                .build()
                .toString();

    }
}
