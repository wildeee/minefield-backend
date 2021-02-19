package br.com.minefield.dto;

import br.com.minefield.domain.GameStatus;

public class GameStatusAndBombsAroundDTO {

    public GameStatus status;
    public Integer bombsAround;

    public GameStatusAndBombsAroundDTO(GameStatus status, Integer bombsAround) {
        this.status = status;
        this.bombsAround = bombsAround;
    }

}
