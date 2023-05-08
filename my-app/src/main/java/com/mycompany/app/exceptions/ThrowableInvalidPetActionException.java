package com.mycompany.app.exceptions;

public class ThrowableInvalidPetActionException extends Exception {
    public String reason;

    public ThrowableInvalidPetActionException(String reason) {
        this.reason = reason;
    }
}
