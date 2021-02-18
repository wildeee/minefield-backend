package br.com.minefield.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.minefield.domain.Coordinate;
import br.com.minefield.domain.GameSession;

@ApplicationScoped
public class MapService {

    @Transactional
    public void generateMap(GameSession gameSession) {
        List<Coordinate> map = new MapGenerator(gameSession).generate();
        Coordinate.persist(map);
    }

    public void deleteMap() {
        Coordinate.deleteAll();
    }
}
