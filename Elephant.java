import org.apache.logging.log4j.*;

public class Elephant extends WildAnimal {
    // Properties.
    private int heightInFeet;
    private String sex;
    private Logger logger;

    // Constructor.
    public Elephant(String homeContinent, String color, int heightInFeet, String sex, Logger logger) {
        this.homeContinent = homeContinent;
        this.color = color;
        this.heightInFeet = heightInFeet;
        this.sex = sex;
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
    
    public int getHeightInFeet() {
        return this.heightInFeet;
    }

    public void setHeightInFeet(int newHeight) {
        this.heightInFeet = newHeight;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String newSex) {
        this.sex = newSex;
    }

    // Other methods.
    public String toString() {
        return "Elephant Home Continent: " + this.homeContinent + ", Color: " + this.color + ", Height in feet: " + this.heightInFeet + 
            ", Sex: " + this.sex;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.heightInFeet;
        return result;
    }

    public void eat() {
        logger.info("An elephant that is " + this.heightInFeet + " feet tall is eating.");
    }

    public void makeNoise(String noise) throws InvalidSoundException {
        super.makeNoise(noise);
        logger.info("An elephant that is " + this.heightInFeet + " feet tall is making a " + noise + " sound.");
    }

    public void lookForFood(String food) throws InvalidFoodException {
        super.lookForFood(food);
        logger.info("An elephant that is " + this.heightInFeet + " feet tall is looking for " + food + ".");
    }

    public void mate() {
        logger.info("An elephant that is " + this.heightInFeet + " feet tall is mating.");

    }
}