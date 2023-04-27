public class InvalidFoodException extends Exception {
    String reason;
    
    public InvalidFoodException(String reason) {
        this.reason = reason;
    }
}
