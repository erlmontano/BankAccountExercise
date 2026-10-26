package exception;

/**
 * Exception thrown when an invalid deposit or withdrawal amount is provided.
 */
public class InvalidAmountException extends Exception {
    private String message;
    /**
     * create InvalidAmountException.
     */
    public InvalidAmountException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}