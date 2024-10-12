package exceptions;

public class ParkingSpaceRequiredException extends RuntimeException {
    public ParkingSpaceRequiredException(String message) {
        super(message);
    }
}