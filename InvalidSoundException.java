public class InvalidSoundException extends Exception {
    String reason;

    public InvalidSoundException(String reason) {
        this.reason = reason;
    }
}
