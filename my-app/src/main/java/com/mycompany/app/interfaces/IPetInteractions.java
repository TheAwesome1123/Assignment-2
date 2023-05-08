package com.mycompany.app.interfaces;

import com.mycompany.app.exceptions.ThrowableInvalidPetActionException;

public interface IPetInteractions {
    public void pet();
    public void teach(String action) throws ThrowableInvalidPetActionException;
}
