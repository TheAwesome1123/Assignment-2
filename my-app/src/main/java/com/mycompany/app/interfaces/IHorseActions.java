package com.mycompany.app.interfaces;

import com.mycompany.app.exceptions.ThrowableInvalidNumFeetException;

public interface IHorseActions {
    public void jump(int feet) throws ThrowableInvalidNumFeetException;
}
