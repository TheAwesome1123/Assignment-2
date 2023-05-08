package com.mycompany.app.animals;

import org.apache.logging.log4j.*;

import com.mycompany.app.abstracts.WildAnimal;
import com.mycompany.app.exceptions.*;

public class Wolf extends WildAnimal {
    // Properties.
    private int packSize;
    private Logger logger;

    // Constructor.
    public Wolf(String homeContinent, String color, int packSize, Logger logger) {
        this.homeContinent = homeContinent;
        this.color = color;
        this.packSize = packSize;
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

    public int getPackSize() {
        return this.packSize;
    }

    public void setPackSize(int newSize) {
        this.packSize = newSize;
    }

    // Other methods.
    public String toString() {
        return "Wolf Home Continent: " + this.homeContinent + ", Color: " + this.color + ", Pack Size: " + this.packSize;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.packSize;
        return result;
    }

    public void eat() {
        logger.info("A " + this.color + " wolf is eating with other wolves in its pack of " + this.packSize + ".");
    }

    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        super.makeNoise(color);
        logger.info("A " + this.color + " wolf is making a " + noise + " sound.");
    }

    public void lookForFood(String food) throws ThrowableInvalidFoodException {
        super.lookForFood(food);
        logger.info("A " + this.color + " wolf is hunting with its pack for " + food + ".");
    }

    public void mate() {
        logger.info("A " + this.color + " wolf is mating.");
    }
}