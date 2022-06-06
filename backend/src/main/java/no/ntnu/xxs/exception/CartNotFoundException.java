package no.ntnu.xxs.exception;

/**
 * Throw this exception when a cart doesn't exist or isn't found
 */
public class CartNotFoundException extends Exception {
    public CartNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
