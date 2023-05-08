package com.mycompany.app.exceptions;

public class ThrowableInvalidSoundException extends Exception {
    public String reason;

    public ThrowableInvalidSoundException(String reason) {
        this.reason = reason;
    }
}
