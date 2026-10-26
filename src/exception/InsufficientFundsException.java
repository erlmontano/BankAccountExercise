package exception;

/**
 * Exception thrown when a withdrawal exceeds available balance.
 */
public class InsufficientFundsException extends Exception {
    private String message;

    /**
     * create InsufficientFundsException.
     */
    public InsufficientFundsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}