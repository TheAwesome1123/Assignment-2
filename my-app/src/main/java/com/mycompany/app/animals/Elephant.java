package com.mycompany.app.animals;

import com.mycompany.app.enums.HomeContinent;
import org.apache.logging.log4j.*;

import com.mycompany.app.abstracts.WildAnimal;
import com.mycompany.app.exceptions.*;
import com.mycompany.app.enums.Sex;

public class Elephant extends WildAnimal {
    // Properties.
    private int heightInFeet;

    // Constructor.
    public Elephant(Sex sex, HomeContinent homeContinent, String color, int heightInFeet) {
        this.sex = sex;
        this.homeContinent = homeContinent;
        this.color = color;
        this.heightInFeet = heightInFeet;
    }

    // Getters/setters.
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

    // Other methods.
    public String toString() {
        return "Elephant Sex: " + this.sex + ", Home Continent: " + this.homeContinent + ", Color: " + this.color +
            ", Height in feet: " + this.heightInFeet + ", Sex: " + this.sex;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.heightInFeet;
        return result;
    }

    public void eat() {
        LOGGER.info("An elephant that is " + this.heightInFeet + " feet tall is eating.");
    }

    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        super.makeNoise(noise);
        LOGGER.info("An elephant that is " + this.heightInFeet + " feet tall is making a " + noise + " sound.");
    }

    public void lookForFood(String food) throws ThrowableInvalidFoodException {
        super.lookForFood(food);
        LOGGER.info("An elephant that is " + this.heightInFeet + " feet tall is looking for " + food + ".");
    }

    public void mate() {
        LOGGER.info("An elephant that is " + this.heightInFeet + " feet tall is mating.");

    }
}