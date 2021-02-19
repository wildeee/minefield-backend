package br.com.minefield.repository;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import br.com.minefield.domain.GameSession;
import br.com.minefield.domain.GameStatus;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class GameSessionRepository implements PanacheRepository<GameSession> {

    public Optional<GameSession> findGameSession() {
        return find("status = ?1", GameStatus.IN_PROGRESS)
                .firstResultOptional();
    }

}
