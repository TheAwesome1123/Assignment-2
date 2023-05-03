package interfaces;
import exceptions.InvalidPetActionException;

public interface PetInteractions {
    public void pet();
    public void teach(String action) throws InvalidPetActionException;
}
