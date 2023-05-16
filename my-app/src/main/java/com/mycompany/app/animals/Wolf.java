package com.mycompany.app.animals;

import com.mycompany.app.enums.HomeContinent;
import org.apache.logging.log4j.*;
import com.mycompany.app.abstracts.WildAnimal;
import com.mycompany.app.exceptions.*;
import com.mycompany.app.enums.Sex;

public class Wolf extends WildAnimal {
    // Properties.
    private int packSize;

    // Constructor.
    public Wolf(Sex sex, HomeContinent homeContinent, String color, int packSize) {
        this.sex = sex;
        this.homeContinent = homeContinent;
        this.color = color;
        this.packSize = packSize;
    }

    // Getters/setters.
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
        return "Wolf Sex: " + this.sex + ", Home Continent: " + this.homeContinent + ", Color: " + this.color +
            ", Pack Size: " + this.packSize;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.packSize;
        return result;
    }

    public void eat() {
        LOGGER.info("A " + this.color + " wolf is eating with other wolves in its pack of " + this.packSize + ".");
    }

    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        super.makeNoise(color);
        LOGGER.info("A " + this.color + " wolf is making a " + noise + " sound.");
    }

    public void lookForFood(String food) throws ThrowableInvalidFoodException {
        super.lookForFood(food);
        LOGGER.info("A " + this.color + " wolf is hunting with its pack for " + food + ".");
    }

    public void mate() {
        LOGGER.info("A " + this.color + " wolf is mating.");
    }
}