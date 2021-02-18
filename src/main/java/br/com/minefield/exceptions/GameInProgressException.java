package br.com.minefield.exceptions;

public class GameInProgressException extends MinefieldException {
    private static final long serialVersionUID = 8318868977876924600L;

    public GameInProgressException() {
        super("There is a game in progress already.");
    }
}
