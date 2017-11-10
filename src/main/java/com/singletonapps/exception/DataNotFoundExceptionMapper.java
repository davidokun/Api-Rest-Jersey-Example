package com.singletonapps.exception;

import com.singletonapps.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException ex) {

        ErrorMessage errorMessage = new ErrorMessage(Status.NOT_FOUND.getStatusCode(), ex.getMessage());

        return Response.status(Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}
