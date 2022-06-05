package no.ntnu.xxs.exception;

/**
 * Throw this exception when a product already exists
 */
public class ProductAlreadyExistException extends Exception {
    public ProductAlreadyExistException(String errorMsg) {
        super(errorMsg);
    }
}
