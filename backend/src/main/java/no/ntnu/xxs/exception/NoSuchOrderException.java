package no.ntnu.xxs.exception;

public class NoSuchOrderException extends Exception{
    public NoSuchOrderException(String errorMsg) {
        super(errorMsg);
    }
}
