package com.mycompany.app.interfaces;

import com.mycompany.app.exceptions.ThrowableInvalidFoodException;

public interface IWildAnimalBehaviors {
    public void lookForFood(String food) throws ThrowableInvalidFoodException;
    public void mate();
}
