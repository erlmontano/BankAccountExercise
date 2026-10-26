package exception;

/**
 * Exception thrown when operations are attempted on a frozen account.
 */
public class AccountFrozenException extends Exception {
    private String message;

    /**
     * create AccountFrozenException.
     */
    public AccountFrozenException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}