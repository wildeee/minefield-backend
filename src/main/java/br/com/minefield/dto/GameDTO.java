package br.com.minefield.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class GameDTO {

    @Min(value = 1, message = "Must have at least 1 row")
    @NotNull
    public Integer rows;

    @Min(value = 1, message = "Must have at least 1 col")
    @NotNull
    public Integer cols;

    @Min(value = 1, message = "Must have at least 1 bomb")
    @NotNull
    public Integer bombsAmount;

}
