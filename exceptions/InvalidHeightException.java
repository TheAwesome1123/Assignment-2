package exceptions;

public class InvalidHeightException extends Exception {
    public String reason;
    
    public InvalidHeightException(String reason) {
        this.reason = reason;
    }
}
