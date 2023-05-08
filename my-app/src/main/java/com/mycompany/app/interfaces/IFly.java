package com.mycompany.app.interfaces;

import com.mycompany.app.exceptions.ThrowableInvalidHeightException;

public interface IFly {
    public void fly(int height) throws ThrowableInvalidHeightException;
}
