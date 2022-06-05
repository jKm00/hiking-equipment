package no.ntnu.xxs.exception;

public class CartNotFoundException extends Exception {
    public CartNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
