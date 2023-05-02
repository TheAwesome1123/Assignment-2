import org.apache.logging.log4j.*;

public abstract class WildAnimal extends Animal implements WildAnimalBehaviors {
    protected String homeContinent;
    protected String color;
    protected Logger logger = LogManager.getLogger("WildAnimalLogger");

    public final void printStatement() {
        logger.info("Wild animals are not pets.");
    }

    public void lookForFood(String food) throws InvalidFoodException {
        if(food.length() < 4) {
            throw new InvalidFoodException("Invalid food.");
        }
    }

}
