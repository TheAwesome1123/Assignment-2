package com.mycompany.app.exceptions;

public class ThrowableInvalidFoodException extends Exception {
    public String reason;
    
    public ThrowableInvalidFoodException(String reason) {
        this.reason = reason;
    }
}
