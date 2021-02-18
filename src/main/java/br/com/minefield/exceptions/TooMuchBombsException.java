package br.com.minefield.exceptions;

public class TooMuchBombsException extends MinefieldException {
    private static final long serialVersionUID = -3761741051967007262L;

    public TooMuchBombsException(Integer maximumBombsAmount) {
        super(String.format("This map allows at most %d bombs.", maximumBombsAmount));
    }
}
