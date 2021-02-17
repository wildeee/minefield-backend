package br.com.minefield.services;

import java.time.Clock;
import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.minefield.domain.GameSession;
import br.com.minefield.dto.GameDTO;
import br.com.minefield.exceptions.GameInProgressException;
import br.com.minefield.repository.GameSessionRepository;

@ApplicationScoped
public class GameSessionService {

    private GameSessionRepository repository;

    public GameSessionService(GameSessionRepository repository) {
        this.repository = repository;
    }

    public GameSession findCurrentGame() {
        return repository.findGameSession();
    }

    @Transactional
    public GameSession newGame(GameDTO game) {
        validateGameInProgress();
        GameSession gameSession = toGameSession(game);
        gameSession.persist();
        return gameSession;
    }

    private static GameSession toGameSession(GameDTO game) {
        return GameSession.builder()
                .withRows(game.rows)
                .withCols(game.cols)
                .withBombsAmount(game.bombsAmount)
                .withStartedAt(LocalDateTime.now(Clock.systemUTC()))
                .build();
    }

    private void validateGameInProgress() {
        long count = GameSession.count();
        if (count > 0) {
            throw new GameInProgressException();
        }
    }

}
