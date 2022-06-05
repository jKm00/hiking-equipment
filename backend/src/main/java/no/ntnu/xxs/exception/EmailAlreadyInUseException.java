package no.ntnu.xxs.exception;

/**
 * Throw this exception when an email already exists
 */
public class EmailAlreadyInUseException extends Exception{
    public EmailAlreadyInUseException(String errorMsg) {
        super(errorMsg);
    }
}
