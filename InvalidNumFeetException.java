public class InvalidNumFeetException extends Exception {
    String reason;
    
    public InvalidNumFeetException(String reason) {
        this.reason = reason;
    }
}
