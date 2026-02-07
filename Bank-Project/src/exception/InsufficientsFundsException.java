package exception;

public class InsufficientsFundsException extends RuntimeException {
    public InsufficientsFundsException(String message) {
        super(message);
    }
}
