package exceptions;

public class NoAvailableParkingSpaceException extends RuntimeException {
    public NoAvailableParkingSpaceException(String message) {
        super(message);
    }
}