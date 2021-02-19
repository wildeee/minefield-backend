package br.com.minefield.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.minefield.domain.Coordinate;
import br.com.minefield.domain.GameSession;
import br.com.minefield.domain.GameStatus;
import br.com.minefield.dto.GameStatusAndBombsAroundDTO;
import br.com.minefield.dto.PointDTO;
import br.com.minefield.exceptions.NoGameInProgressException;

@ApplicationScoped
public class RevealService {

    private final GameSessionService gameSessionService;
    private final PointValidationService pointValidationService;

    public RevealService(GameSessionService gameSessionService, PointValidationService pointValidationService) {
        this.gameSessionService = gameSessionService;
        this.pointValidationService = pointValidationService;
    }

    public GameStatusAndBombsAroundDTO reveal(PointDTO point) {
        GameSession currentGame = gameSessionService.findCurrentGame().orElseThrow(NoGameInProgressException::new);
        pointValidationService.validatePoint(currentGame, point);
        Coordinate coordinate = saveReveal(point);
        if (Boolean.TRUE.equals(coordinate.getBomb())) {
            loseGame(currentGame);
            return new GameStatusAndBombsAroundDTO(GameStatus.LOSE, coordinate.getBombsAround());
        }
        if (gameIsWon()) {
            winGame(currentGame);
            return new GameStatusAndBombsAroundDTO(GameStatus.WIN, coordinate.getBombsAround());
        }
        return new GameStatusAndBombsAroundDTO(GameStatus.IN_PROGRESS, coordinate.getBombsAround());
    }

    private boolean gameIsWon() {
        List<Coordinate> bombCoordinates = Coordinate.list("bomb is false");
        return bombCoordinates.stream().allMatch(Coordinate::getRevealed);
    }

    private Coordinate saveReveal(PointDTO point) {
        Coordinate coordinate = Coordinate.find("x = ?1 and y = ?2", point.x, point.y).firstResult();
        coordinate.setRevealed(true);
        coordinate.persistAndFlush();
        return coordinate;
    }

    private void loseGame(GameSession game) {
        gameSessionService.lose(game);
    }

    private void winGame(GameSession game) {
        gameSessionService.win(game);
    }

}
