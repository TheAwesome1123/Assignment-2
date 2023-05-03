package animals;
import org.apache.logging.log4j.*;
import abstracts.WildAnimal;
import exceptions.*;

public class Squirrel extends WildAnimal {
    // Properties.
    private int numOfVisitsToHousePerDay;
    private Logger logger;

    // Constructor.
    public Squirrel(String homeContinent, String color, int numOfVisitsToHousePerDay, Logger logger) {
        this.homeContinent = homeContinent;
        this.color = color;
        this.numOfVisitsToHousePerDay = numOfVisitsToHousePerDay;
        this.logger = logger;
    }

    // Getters/setters.
    public String getHomeContinent() {
        return this.homeContinent;
    }

    public void setHomeContinent(String newContinent) {
        this.homeContinent = newContinent;
    }
    
    public String getColor() {
        return this.color;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public int getnumOfVisitsToHousePerDay() {
        return this.numOfVisitsToHousePerDay;
    }

    public void setnumOfVisitsToHousePerDay(int newNumOfVisits) {
        this.numOfVisitsToHousePerDay = newNumOfVisits;
    }

    // Other methods.
    public String toString() {
        return "Squirrel Home Continent: " + this.homeContinent + ", Color: " + this.color + ", Number of Visits to a House per Day: " + 
            this.numOfVisitsToHousePerDay;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.numOfVisitsToHousePerDay;
        return result;
    }

    public void eat() {
        logger.info("A " + this.color + " squirrel is eating nuts.");
    }

    public void makeNoise(String noise) throws InvalidSoundException {
        super.makeNoise(noise);
        logger.info("A " + this.color + " squirrel is making a " + noise + " sound.");
    }

    public void lookForFood(String food) throws InvalidFoodException {
        super.lookForFood(food);
        logger.info("A " + this.color + " squirrel is looking for ." + food + ".");
    }

    public void mate() {
        logger.info("A " + this.color + " squirrel is mating.");
    }
}