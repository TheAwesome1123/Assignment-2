package interfaces;

import exceptions.InvalidFoodException;

public interface WildAnimalBehaviors {
    public void lookForFood(String food) throws InvalidFoodException;
    public void mate();
}
