package no.ntnu.xxs.exception;

/**
 * Throw this exception when user doesn't exist or isn't found
 */
public class NoSuchUserException extends Exception {
    public NoSuchUserException(String errorMsg) {
        super(errorMsg);
    }
}
