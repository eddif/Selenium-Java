package bizops.exceptions;

public class UnknownBrowserException extends RuntimeException {
    public UnknownBrowserException(String message) {
        super(message);
    }
}
