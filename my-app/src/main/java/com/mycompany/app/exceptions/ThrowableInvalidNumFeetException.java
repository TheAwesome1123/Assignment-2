package com.mycompany.app.exceptions;

public class ThrowableInvalidNumFeetException extends Exception {
    public String reason;
    
    public ThrowableInvalidNumFeetException(String reason) {
        this.reason = reason;
    }
}
