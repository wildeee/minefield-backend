package br.com.minefield.exceptions;

public class PointOutOfBoundsException extends MinefieldException {
    private static final long serialVersionUID = -8323053344324533923L;

    public PointOutOfBoundsException(Integer x, Integer y) {
        super(String.format("The point (x, y)(%d, %d) does not exist on map", x, y));
    }

}
