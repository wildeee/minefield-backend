package br.com.minefield.exceptions;

public abstract class MinefieldException extends RuntimeException {
    private static final long serialVersionUID = -5103077074007978216L;

    public MinefieldException(String message) {
        super(message);
    }

}
