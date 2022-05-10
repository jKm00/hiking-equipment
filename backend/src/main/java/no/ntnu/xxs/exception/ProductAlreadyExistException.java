package no.ntnu.xxs.exception;

public class ProductAlreadyExistException extends Exception {
    public ProductAlreadyExistException(String errorMsg) {
        super(errorMsg);
    }
}
