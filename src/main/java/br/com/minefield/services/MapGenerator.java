package br.com.minefield.services;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.minefield.domain.Coordinate;
import br.com.minefield.domain.GameSession;

public class MapGenerator {

    private final GameSession gameSession;
    private final List<Point> bombs;
    private final List<Coordinate> map;

    public MapGenerator(GameSession gameSession) {
        this.gameSession = gameSession;
        this.bombs = new ArrayList<>();
        this.map = new ArrayList<>();
    }

    public List<Coordinate> generate() {
        sortBombs();
        for (int x = 0; x < gameSession.getRows(); x++) {
            for (int y = 0; y < gameSession.getCols(); y++) {
                Integer bombsAround = countBombsAround(x, y);
                buildCoordinate(x, y, bombsAround);
            }
        }
        return map;
    }

    private Integer countBombsAround(int x, int y) {
        int bombsAround = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (hasBomb(x + i, y + j)) bombsAround++;
            }
        }
        return bombsAround;
    }

    private boolean hasBomb(int x, int y) {
        if (x < 0 || x >= gameSession.getCols() || y < 0 || y >= gameSession.getRows()) {
            return false;
        }
        Point possibleBomb = new Point(x, y);
        return bombs.stream().anyMatch((Point bomb) -> bomb.equals(possibleBomb));
    }

    private void buildCoordinate(int x, int y, int bombsAround) {
        Boolean isBomb = hasBomb(x, y);
        Coordinate coordinate = Coordinate.builder()
            .withGameSession(gameSession)
            .withBombsAround(bombsAround)
            .withX(x)
            .withY(y)
            .withFlagged(false)
            .withRevealed(false)
            .withBomb(isBomb)
            .build();
        map.add(coordinate);
    }

    private List<Point> sortBombs() {
        while(bombs.size() < gameSession.getBombsAmount()) {
            Point bomb = generateBombPoint(gameSession.getRows(), gameSession.getCols());
            boolean isAlreadySorted = bombs.stream().anyMatch((Point bombPoint) -> bombPoint.equals(bomb));
            if (!isAlreadySorted) {
                bombs.add(bomb);
            }
        }
        return bombs;
    }

    private Point generateBombPoint(Integer rows, Integer cols) {
        Integer x = generateCoordinate(cols);
        Integer y = generateCoordinate(rows);
        return new Point(x, y);
    }

    private Integer generateCoordinate(Integer maximumExclusive) {
        return new Random().nextInt(maximumExclusive);
    }

}
