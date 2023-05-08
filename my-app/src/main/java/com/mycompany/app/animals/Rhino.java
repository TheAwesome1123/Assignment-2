package com.mycompany.app.animals;

import org.apache.logging.log4j.*;

import com.mycompany.app.abstracts.WildAnimal;
import com.mycompany.app.exceptions.*;

public class Rhino extends WildAnimal {
    // Properties.
    private int weightInPounds;
    private Logger logger;

    // Constructor.
    public Rhino(String homeContinent, String color, int weightInPounds, Logger logger) {
        this.homeContinent = homeContinent;
        this.color = color;
        this.weightInPounds = weightInPounds;
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

    public int getWeightInPounds() {
        return this.weightInPounds;
    }

    public void setWeightInPounds(int newWeight) {
        this.weightInPounds = newWeight;
    }

    // Other methods.
    public String toString() {
        return "Rhino Home Continent: " + this.homeContinent + ", Color: " + this.color + ", Weight in Pounds: " + this.weightInPounds;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.weightInPounds;
        return result;
    }

    public void eat() {
        logger.info("A rhino that weighs " + this.weightInPounds + " pounds is eating.");
    }

    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        super.makeNoise(noise);
        logger.info("A rhino that weighs " + this.weightInPounds + " pounds is making a " + noise + " sound.");
    }

    public void lookForFood(String food) throws ThrowableInvalidFoodException {
        super.lookForFood(food);
        logger.info("A rhino that weighs " + this.weightInPounds + " pounds is looking for " + food + ".");
    }

    public void mate() {
        logger.info("A rhino that weighs " + this.weightInPounds + " pounds is mating.");
    }
}