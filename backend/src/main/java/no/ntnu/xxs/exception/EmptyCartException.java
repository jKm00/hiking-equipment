package no.ntnu.xxs.exception;

public class EmptyCartException extends Exception{
    public EmptyCartException(String errorMsg) {
        super(errorMsg);
    }
}
