package br.com.minefield.dto;

import br.com.minefield.domain.Coordinate;

public class RevealedCoordinateDTO extends CoordinateDTO {

    public Integer bombsAround;

    public RevealedCoordinateDTO(Coordinate coordinate) {
        super(coordinate);
        bombsAround = coordinate.getBombsAround();
    }
}
