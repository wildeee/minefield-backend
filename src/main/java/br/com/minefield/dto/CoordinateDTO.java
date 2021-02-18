package br.com.minefield.dto;

import br.com.minefield.domain.Coordinate;

public class CoordinateDTO {

    public Integer x;
    public Integer y;
    public Boolean flagged;
    public Boolean revealed;

    public CoordinateDTO(Coordinate coordinate) {
        x = coordinate.getX();
        y = coordinate.getY();
        flagged = coordinate.getFlagged();
        revealed = coordinate.getRevealed();
    }

}
