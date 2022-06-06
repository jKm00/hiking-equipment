package no.ntnu.xxs.exception;

/**
 * Throw this exception when a cart item doesn't exist or isn't found
 */
public class CartItemNotFoundException extends Exception {
    public CartItemNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
