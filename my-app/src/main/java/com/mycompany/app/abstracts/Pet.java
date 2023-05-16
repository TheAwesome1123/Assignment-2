package com.mycompany.app.abstracts;

import org.apache.logging.log4j.*;
import com.mycompany.app.exceptions.ThrowableInvalidPetActionException;
import com.mycompany.app.interfaces.IPetInteractions;

public abstract class Pet extends Animal implements IPetInteractions {
    protected String name;
    protected int age;
    protected String owner;
    protected static final Logger LOGGER = LogManager.getLogger("PetLogger");

    protected abstract void adopt();

    public void teach(String action) throws ThrowableInvalidPetActionException {
        if(action.length() < 1 || action.length() >= 15) {
            throw new ThrowableInvalidPetActionException("Action too short or long.");
        }
        else {
            LOGGER.info(this.owner + " is teaching a " + this.getClass().getTypeName() +
            " named " + this.name + " how to " + action + ".");
        }
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String newOwner) {
        this.owner = newOwner;
    }
}
