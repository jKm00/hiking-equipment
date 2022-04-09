package no.ntnu.xxs.user;

/**
 * Throw this exception when user already exists
 */

public class UserAlreadyExistException extends Exception {

    private String message;

    public UserAlreadyExistException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }



}
