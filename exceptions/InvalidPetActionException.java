package exceptions;

public class InvalidPetActionException extends Exception {
    public String reason;

    public InvalidPetActionException(String reason) {
        this.reason = reason;
    }
}
