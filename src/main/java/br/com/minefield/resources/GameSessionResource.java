package br.com.minefield.resources;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.com.minefield.domain.GameSession;
import br.com.minefield.dto.GameDTO;
import br.com.minefield.services.GameSessionService;

@Path("/game-sessions")
public class GameSessionResource {

    private GameSessionService gameSessionService;

    public GameSessionResource(GameSessionService gameSessionService) {
        this.gameSessionService = gameSessionService;
    }

    @GET
    public Optional<GameSession> findGameSession() {
        return gameSessionService.findCurrentGame();
    }

    @POST
    @Transactional
    public GameSession newSession(@Valid GameDTO game) {
        return gameSessionService.newGame(game);
    }

    @DELETE
    @Transactional
    public boolean deleteSession() {
        return gameSessionService.deleteGame();
    }
}
