package bizops.exceptions;

public class UnknownPropertyException extends RuntimeException {
    public UnknownPropertyException(String message) {
        super(message);
    }
}
