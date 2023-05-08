package com.mycompany.app.abstracts;

import com.mycompany.app.exceptions.ThrowableInvalidSoundException;
import com.mycompany.app.interfaces.IAnimalActions;

public abstract class Animal implements IAnimalActions {
    public void eat() {

    }
    
    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        if(!noise.matches("\"[a-zA-Z]+\"")) {
            throw new ThrowableInvalidSoundException("Invalid noise representation.");
        }
    }
}
