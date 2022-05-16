package no.ntnu.xxs.exception;

public class QuantityBelowZeroException extends Exception {
    private String message;

    public QuantityBelowZeroException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
