package br.com.minefield.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PointDTO {

    @NotNull
    @Min(value = 0, message = "x should be at least 0")
    public Integer x;

    @NotNull
    @Min(value = 0, message = "y should be at least 0")
    public Integer y;

}
