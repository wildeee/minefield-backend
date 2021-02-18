package br.com.minefield.exceptions.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.minefield.dto.ErrorDTO;
import br.com.minefield.exceptions.MinefieldException;

@Provider
public class MinefieldExceptionHandler implements ExceptionMapper<MinefieldException> {

    @Override
    public Response toResponse(MinefieldException exception) {
        return Response.status(400)
                .entity(new ErrorDTO(exception.getMessage()))
                .build();
    }

}
