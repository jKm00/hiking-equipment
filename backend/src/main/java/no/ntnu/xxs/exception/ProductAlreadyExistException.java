package no.ntnu.xxs.exception;

import no.ntnu.xxs.product.Product;

public class ProductAlreadyExistException extends Exception {
    public ProductAlreadyExistException(String errorMsg) {
        super(errorMsg);
    }
}
