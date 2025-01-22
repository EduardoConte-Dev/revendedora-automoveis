package org.eduardoconte.Exception;

import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GeneralException implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        if (e instanceof PersistenceException){
            return Response.status(Response.Status.OK).entity(e.getMessage()).build();
        }

        if (e instanceof NotExistArgumentException){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

        if (e instanceof ConstraintViolationException){
            return Response.status(Response.Status.NOT_MODIFIED).entity(e.getMessage()).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
}
