package no.ntnu.xxs.exception;

/**
 * Throw this exception when an order doesn't exist or isn't found
 */
public class NoSuchOrderException extends Exception{
    public NoSuchOrderException(String errorMsg) {
        super(errorMsg);
    }
}
