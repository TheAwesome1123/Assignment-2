package com.mycompany.app.abstracts;

import org.apache.logging.log4j.*;
import com.mycompany.app.exceptions.*;
import com.mycompany.app.interfaces.IWildAnimalBehaviors;

public abstract class WildAnimal extends Animal implements IWildAnimalBehaviors {
    protected String homeContinent;
    protected String color;
    protected Logger logger = LogManager.getLogger("WildAnimalLogger");

    public final void printStatement() {
        logger.info("Wild animals are not pets.");
    }

    public void lookForFood(String food) throws ThrowableInvalidFoodException {
        if(food.length() < 4) {
            throw new ThrowableInvalidFoodException("Invalid food.");
        }
    }

}
