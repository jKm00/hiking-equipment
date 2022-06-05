package no.ntnu.xxs.exception;

/**
 * Throw this exception when a cart item already exists
 */
public class CartItemAlreadyExistsException extends Exception {
    public CartItemAlreadyExistsException(String errorMsg) {
        super(errorMsg);
    }
}
