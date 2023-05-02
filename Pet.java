import org.apache.logging.log4j.*;

public abstract class Pet extends Animal implements PetInteractions {
    protected String name;
    protected String breed;
    protected int age;
    protected String owner;
    protected Logger logger = LogManager.getLogger("PetLogger");

    protected abstract void adopt();

    public void teach(String action) throws InvalidPetActionException {
        if(action.length() < 1 || action.length() >= 15) {
            throw new InvalidPetActionException("Action too short or long.");
        }
        else {
            logger.info(this.owner + " is teaching a " + this.breed + " " + this.getClass().getTypeName() + 
            " named " + this.name + " how to " + action + ".");
        }
    }
}
