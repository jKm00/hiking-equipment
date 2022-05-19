package no.ntnu.xxs.exception;

public class EmailAlreadyInUseException extends Exception{
    public EmailAlreadyInUseException(String errorMsg) {
        super(errorMsg);
    }
}
