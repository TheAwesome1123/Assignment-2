package interfaces;

import exceptions.InvalidHeightException;

public interface BirdActions {
    public void fly(int height) throws InvalidHeightException;
}
