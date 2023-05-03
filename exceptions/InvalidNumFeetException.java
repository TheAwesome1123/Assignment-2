package exceptions;

public class InvalidNumFeetException extends Exception {
    public String reason;
    
    public InvalidNumFeetException(String reason) {
        this.reason = reason;
    }
}
