public class InvalidPetActionException extends Exception {
    String reason;

    public InvalidPetActionException(String reason) {
        this.reason = reason;
    }
}
