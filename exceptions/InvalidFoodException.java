package exceptions;

public class InvalidFoodException extends Exception {
    public String reason;
    
    public InvalidFoodException(String reason) {
        this.reason = reason;
    }
}
