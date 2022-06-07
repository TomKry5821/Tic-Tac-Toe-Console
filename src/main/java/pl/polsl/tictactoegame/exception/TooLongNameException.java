package pl.polsl.tictactoegame.exception;

/**
 * @author Tomasz Krypczyk
 * @version 1.1 Class representing my own Exception
 */
public class TooLongNameException extends Exception {

    /**
     * TooLongNameException one argument constructor
     *
     * @param message created for the user after throwing an exception
     */
    public TooLongNameException(String message) {
        super(message);
    }
}
