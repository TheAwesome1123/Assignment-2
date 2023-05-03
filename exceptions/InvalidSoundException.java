package exceptions;

public class InvalidSoundException extends Exception {
    public String reason;

    public InvalidSoundException(String reason) {
        this.reason = reason;
    }
}
