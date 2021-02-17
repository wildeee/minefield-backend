package br.com.minefield.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.minefield.domain.GameSession;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class GameSessionRepository implements PanacheRepository<GameSession> {

    public GameSession findGameSession() {
        return findAll().firstResultOptional().orElse(null);
    }

}
