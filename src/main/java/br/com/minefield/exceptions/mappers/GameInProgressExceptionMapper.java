package br.com.minefield.exceptions.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.minefield.exceptions.GameInProgressException;

@Provider
public class GameInProgressExceptionMapper implements ExceptionMapper<GameInProgressException> {

    @Override
    public Response toResponse(GameInProgressException exception) {
        return Response.status(400).build();
    }

}
