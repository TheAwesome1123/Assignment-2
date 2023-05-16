package com.mycompany.app.abstracts;

import org.apache.logging.log4j.*;
import com.mycompany.app.exceptions.*;
import com.mycompany.app.interfaces.IWildAnimalBehaviors;
import com.mycompany.app.enums.HomeContinent;

public abstract class WildAnimal extends Animal implements IWildAnimalBehaviors {
    protected HomeContinent homeContinent;
    protected String color;
    protected static final Logger LOGGER = LogManager.getLogger("WildAnimalLogger");

    public final void printStatement() {
        LOGGER.info("Wild animals are not pets.");
    }

    public void lookForFood(String food) throws ThrowableInvalidFoodException {
        if(food.length() < 4) {
            throw new ThrowableInvalidFoodException("Invalid food.");
        }
    }

    public HomeContinent getHomeContinent() {
        return this.homeContinent;
    }

    public void setHomeContinent(HomeContinent newContinent) {
        this.homeContinent = newContinent;
    }
}
