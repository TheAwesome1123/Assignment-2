public class InvalidHeightException extends Exception {
    String reason;
    
    public InvalidHeightException(String reason) {
        this.reason = reason;
    }
}
