package com.singletonapps.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messages")
public class MessageResource {

    @GET
    @Produces("text/plain")
    public String getMessages(){
        return "Hello World!!";
    }
}
