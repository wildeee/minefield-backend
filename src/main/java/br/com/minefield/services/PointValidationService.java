package br.com.minefield.services;

import javax.enterprise.context.ApplicationScoped;

import br.com.minefield.domain.GameSession;
import br.com.minefield.dto.PointDTO;
import br.com.minefield.exceptions.PointOutOfBoundsException;

@ApplicationScoped
public class PointValidationService {

    public void validatePoint(GameSession currentGame, PointDTO point) {
        if (!isValidPoint(currentGame, point)) {
            throw new PointOutOfBoundsException(point.x, point.y);
        }
    }

    private boolean isValidPoint(GameSession currentGame, PointDTO point) {
        return !(
            point.x < 0
            || point.x >= currentGame.getCols()
            || point.y < 0
            || point.y >= currentGame.getRows()
        );
    }

}
