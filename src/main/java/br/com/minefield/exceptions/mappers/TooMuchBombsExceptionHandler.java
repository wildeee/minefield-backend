package br.com.minefield.exceptions.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.minefield.dto.ErrorDTO;
import br.com.minefield.exceptions.TooMuchBombsException;

@Provider
public class TooMuchBombsExceptionHandler implements ExceptionMapper<TooMuchBombsException> {

    @Override
    public Response toResponse(TooMuchBombsException exception) {
        String message = String.format("This map allows at most %d bombs.", exception.getMaximumBombs());
        return Response.status(400)
                .entity(new ErrorDTO(message))
                .build();
    }

}
