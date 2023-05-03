package interfaces;

import exceptions.InvalidNumFeetException;

public interface HorseActions {
    public void jump(int feet) throws InvalidNumFeetException;
}
