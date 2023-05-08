package com.mycompany.app.interfaces;
import com.mycompany.app.exceptions.ThrowableInvalidSoundException;

public interface IAnimalActions {
    public void eat();
    public void makeNoise(String noise) throws ThrowableInvalidSoundException;
}
