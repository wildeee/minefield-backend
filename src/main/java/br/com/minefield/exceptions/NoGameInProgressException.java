package br.com.minefield.exceptions;

public class NoGameInProgressException extends MinefieldException {
    private static final long serialVersionUID = 3420992318154838527L;

    public NoGameInProgressException() {
        super("There is no game in progress now. You should start a new one.");
    }

}
