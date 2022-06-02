package no.ntnu.xxs.exception;

public class CartItemAlreadyExistsException extends Exception {
    public CartItemAlreadyExistsException(String errorMsg) {
        super(errorMsg);
    }
}
