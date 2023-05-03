package animals;

import org.apache.logging.log4j.*;
import abstracts.WildAnimal;
import exceptions.*;

public class Bear extends WildAnimal {
    // Properties.
    private String type;
    private int numOfCubs;
    private Logger logger;

    // Constructor.
    public Bear(String homeContinent, String color, String type, int numOfCubs, Logger logger) {
        this.homeContinent = homeContinent;
        this.color = color;
        this.type = type;
        this.numOfCubs = numOfCubs;
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

    public String getType() {
        return this.type;
    }

    public void setType(String newType) {
        this.type = newType;
    }

    public int getNumCubs() {
        return this.numOfCubs;
    }

    public void setNumCubs(int newNum) {
        this.numOfCubs = newNum;
    }

    // Other methods.
    public String toString() {
        return "Bear Home Continent: " + this.homeContinent + ", Color: " + this.color + ", Type: " + this.type + ", Number of Cubs: " + 
            this.numOfCubs;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.numOfCubs;
        return result;
    }

    public void eat() {
        logger.info("A " + this.type + " bear is eating with " + this.numOfCubs + " cubs.");
    }

    public void makeNoise(String noise) throws InvalidSoundException {
        super.makeNoise(noise);
        logger.info("A " + this.type + " bear is making a " + noise + " noise.");
    }

    public void lookForFood(String food) throws InvalidFoodException {
        super.lookForFood(food);
        logger.info("A " + this.type + " bear is hunting for " + food + ".");
    }

    public void mate() {
        logger.info("A " + this.type + " bear found a mate and will have cubs.");
    }
}