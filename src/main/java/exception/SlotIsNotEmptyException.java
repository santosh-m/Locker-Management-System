package exception;

public class SlotIsNotEmptyException extends RuntimeException {
    public SlotIsNotEmptyException(String message) {
        super(message);
    }
}
