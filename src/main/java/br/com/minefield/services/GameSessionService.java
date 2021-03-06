package br.com.minefield.services;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import br.com.minefield.domain.GameSession;
import br.com.minefield.domain.GameStatus;
import br.com.minefield.dto.GameDTO;
import br.com.minefield.exceptions.GameInProgressException;
import br.com.minefield.exceptions.TooMuchBombsException;
import br.com.minefield.repository.GameSessionRepository;

@ApplicationScoped
public class GameSessionService {

    private GameSessionRepository repository;
    private MapService mapService;

    public GameSessionService(GameSessionRepository repository, MapService mapService) {
        this.repository = repository;
        this.mapService = mapService;
    }

    public Optional<GameSession> findCurrentGame() {
        return repository.findGameSession();
    }

    public GameSession newGame(GameDTO game) {
        validateGameInProgress();
        validateBombsAmount(game);
        GameSession gameSession = toNewGameSession(game);
        gameSession.persist();
        mapService.generateMap(gameSession);
        return gameSession;
    }

    public boolean deleteGame() {
        mapService.deleteMap();
        return GameSession.deleteAll() > 0L;
    }

    private static GameSession toNewGameSession(GameDTO game) {
        return GameSession.builder()
                .withRows(game.rows)
                .withCols(game.cols)
                .withBombsAmount(game.bombsAmount)
                .withStartedAt(LocalDateTime.now(Clock.systemUTC()))
                .withStatus(GameStatus.IN_PROGRESS)
                .build();
    }

    private void validateGameInProgress() {
        long count = GameSession.count();
        if (count > 0) {
            throw new GameInProgressException();
        }
    }

    private void validateBombsAmount(GameDTO game) {
        Integer maximumBombsAmount = game.rows * game.cols;
        if (game.bombsAmount > maximumBombsAmount) {
            throw new TooMuchBombsException(maximumBombsAmount);
        }
    }

    public void lose(GameSession game) {
        game.setStatus(GameStatus.LOSE);
        game.persist();
    }

    public void win(GameSession game) {
        game.setStatus(GameStatus.WIN);
        game.persist();
    }
}
