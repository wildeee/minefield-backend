package br.com.minefield.dto;

import javax.validation.constraints.NotNull;

public class FlagDTO extends PointDTO {

    @NotNull
    public Boolean flagged;

}
