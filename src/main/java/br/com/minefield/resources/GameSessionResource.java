package br.com.minefield.resources;

import javax.validation.Valid;
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
    public GameSession findGameSession() {
        return gameSessionService.findCurrentGame();
    }

    @POST
    public GameSession newSession(@Valid GameDTO game) {
        return gameSessionService.newGame(game);
    }
}
