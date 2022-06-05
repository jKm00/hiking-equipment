package no.ntnu.xxs.exception;

/**
 * Throw this exception when cart is empty
 */
public class EmptyCartException extends Exception{
    public EmptyCartException(String errorMsg) {
        super(errorMsg);
    }
}
