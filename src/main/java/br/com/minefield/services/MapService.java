package br.com.minefield.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import br.com.minefield.domain.Coordinate;
import br.com.minefield.domain.GameSession;
import br.com.minefield.dto.CoordinateDTO;
import br.com.minefield.dto.RevealedCoordinateDTO;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class MapService {

    public void generateMap(GameSession gameSession) {
        List<Coordinate> map = new MapGenerator(gameSession).generate();
        Coordinate.persist(map);
    }

    public void deleteMap() {
        Coordinate.deleteAll();
    }

    public List<CoordinateDTO> getMap() {
        List<Coordinate> fullMap = Coordinate.listAll(Sort.by("x", "y"));
        return fullMap.stream()
                .map(this::toCoordinateDTO)
                .collect(Collectors.toList());
    }

    private CoordinateDTO toCoordinateDTO(Coordinate coordinate) {
        if (coordinate.getRevealed()) return new RevealedCoordinateDTO(coordinate);
        return new CoordinateDTO(coordinate);
    }
}
