package abstracts;
import exceptions.InvalidSoundException;
import interfaces.AnimalActions;

public abstract class Animal implements AnimalActions {
    public void eat() {

    }
    
    public void makeNoise(String noise) throws InvalidSoundException {
        if(!noise.matches("\"[a-zA-Z]+\"")) {
            throw new InvalidSoundException("Invalid noise representation.");
        }
    }
}
