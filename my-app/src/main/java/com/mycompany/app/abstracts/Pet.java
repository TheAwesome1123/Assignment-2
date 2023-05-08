package com.mycompany.app.abstracts;

import org.apache.logging.log4j.*;
import com.mycompany.app.exceptions.ThrowableInvalidPetActionException;
import com.mycompany.app.interfaces.IPetInteractions;

public abstract class Pet extends Animal implements IPetInteractions {
    protected String name;
    protected String breed;
    protected int age;
    protected String owner;
    protected Logger logger = LogManager.getLogger("PetLogger");

    protected abstract void adopt();

    public void teach(String action) throws ThrowableInvalidPetActionException {
        if(action.length() < 1 || action.length() >= 15) {
            throw new ThrowableInvalidPetActionException("Action too short or long.");
        }
        else {
            logger.info(this.owner + " is teaching a " + this.breed + " " + this.getClass().getTypeName() + 
            " named " + this.name + " how to " + action + ".");
        }
    }
}
