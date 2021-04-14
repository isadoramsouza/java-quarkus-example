package com.isadora.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GlobalErrorHandler implements ExceptionMapper<Exception>
{
    @Override
    public Response toResponse(Exception exception)
    {
        if (exception instanceof BookNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
        }
    }

}