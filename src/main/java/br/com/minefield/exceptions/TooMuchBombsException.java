package br.com.minefield.exceptions;

public class TooMuchBombsException extends RuntimeException {
    private static final long serialVersionUID = -3761741051967007262L;

    private final Integer maximumBombs;

    public TooMuchBombsException(Integer maximumBombsAmount) {
        maximumBombs = maximumBombsAmount;
    }

    public Integer getMaximumBombs() {
        return maximumBombs;
    }
}
