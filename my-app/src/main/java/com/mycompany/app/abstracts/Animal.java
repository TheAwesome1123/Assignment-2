package com.mycompany.app.abstracts;

import com.mycompany.app.enums.Sex;
import com.mycompany.app.exceptions.ThrowableInvalidSoundException;
import com.mycompany.app.interfaces.IAnimalActions;

public abstract class Animal implements IAnimalActions {
    protected Sex sex;

    public void eat() {

    }
    
    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        if(!noise.matches("\"[a-zA-Z]+\"")) {
            throw new ThrowableInvalidSoundException("Invalid noise representation.");
        }
    }

    public Sex getSex() {
        return this.sex;
    }
}
