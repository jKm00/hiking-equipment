package no.ntnu.xxs.exception;

public class NoSuchUserException extends Exception {
    public NoSuchUserException(String errorMsg) {
        super(errorMsg);
    }
}
