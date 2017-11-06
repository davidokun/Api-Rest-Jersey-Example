package com.singletonapps.endpoints;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

@Path("/annotations")
public class ExampleController {

    @GET
    @Path("matrix")
    public String getMatrixParam(@MatrixParam("name") String name,
                                 @MatrixParam("lastName") String lastName) {

        return "My name is " + name + " " + lastName;

    }

    @GET
    @Path("headers")
    public String getHeaderParam(@HeaderParam("customHeader") String customHeader) {

        return "Custom header is : " + customHeader;
    }

    @GET
    @Path("cookies")
    public String getCookieParam(@CookieParam("myCookie") String myCookie) {

        return "My cookie value is : " + myCookie;
    }

    @GET
    @Path("context")
    public String getContextParams(@Context UriInfo uriInfo,
                                   @Context HttpHeaders httpHeaders ){

        String absolutrPath = uriInfo.getAbsolutePath().toString();
        String headers = httpHeaders.getRequestHeaders().toString();

        return "Path : " + absolutrPath +
                "Headers : " + headers;
    }


}
