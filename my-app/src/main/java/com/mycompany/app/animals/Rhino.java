package com.mycompany.app.animals;

import com.mycompany.app.enums.HomeContinent;
import org.apache.logging.log4j.*;

import com.mycompany.app.abstracts.WildAnimal;
import com.mycompany.app.exceptions.*;
import com.mycompany.app.enums.Sex;

public class Rhino extends WildAnimal {
    // Properties.
    private int weightInPounds;

    // Constructor.
    public Rhino(Sex sex, HomeContinent homeContinent, String color, int weightInPounds) {
        this.sex = sex;
        this.homeContinent = homeContinent;
        this.color = color;
        this.weightInPounds = weightInPounds;
    }

    // Getters/setters.
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
        return "Rhino Sex: " + this.sex + ", Home Continent: " + this.homeContinent + ", Color: " + this.color +
            ", Weight in Pounds: " + this.weightInPounds;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.weightInPounds;
        return result;
    }

    public void eat() {
        LOGGER.info("A rhino that weighs " + this.weightInPounds + " pounds is eating.");
    }

    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        super.makeNoise(noise);
        LOGGER.info("A rhino that weighs " + this.weightInPounds + " pounds is making a " + noise + " sound.");
    }

    public void lookForFood(String food) throws ThrowableInvalidFoodException {
        super.lookForFood(food);
        LOGGER.info("A rhino that weighs " + this.weightInPounds + " pounds is looking for " + food + ".");
    }

    public void mate() {
        LOGGER.info("A rhino that weighs " + this.weightInPounds + " pounds is mating.");
    }
}