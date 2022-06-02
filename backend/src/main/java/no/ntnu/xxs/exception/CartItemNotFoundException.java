package no.ntnu.xxs.exception;

public class CartItemNotFoundException extends Exception {
    public CartItemNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
