package com.mycompany.app.exceptions;

public class ThrowableInvalidHeightException extends Exception {
    public String reason;
    
    public ThrowableInvalidHeightException(String reason) {
        this.reason = reason;
    }
}
