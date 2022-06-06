package no.ntnu.xxs.exception;

/**
 * Throw this exception when the quantity is below zero
 */
public class QuantityBelowZeroException extends Exception {
    private String message;

    public QuantityBelowZeroException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
