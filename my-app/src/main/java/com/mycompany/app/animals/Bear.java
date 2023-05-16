package com.mycompany.app.animals;

import com.mycompany.app.enums.BearType;
import com.mycompany.app.enums.HomeContinent;
import com.mycompany.app.enums.Sex;
import com.mycompany.app.abstracts.WildAnimal;
import com.mycompany.app.exceptions.*;

public class Bear extends WildAnimal {
    // Properties.
    private BearType type;
    private int numOfCubs;

    // Constructor.
    public Bear(Sex sex, HomeContinent homeContinent, String color, BearType type, int numOfCubs) {
        this.sex = sex;
        this.homeContinent = homeContinent;
        this.color = color;
        this.type = type;
        this.numOfCubs = numOfCubs;
    }

    // Getters/setters.
    public String getColor() {
        return this.color;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public BearType getType() {
        return this.type;
    }

    public void setType(BearType newType) {
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
        return "Bear Sex: " + this.sex + ", Home Continent: " + this.homeContinent + ", Color: " + this.color +
            ", Type: " + this.type + ", Number of Cubs: " + this.numOfCubs;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.numOfCubs;
        return result;
    }

    public void eat() {
        LOGGER.info("A " + this.type + " bear is eating with " + this.numOfCubs + " cubs.");
    }

    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        super.makeNoise(noise);
        LOGGER.info("A " + this.type + " bear is making a " + noise + " noise.");
    }

    public void lookForFood(String food) throws ThrowableInvalidFoodException {
        super.lookForFood(food);
        LOGGER.info("A " + this.type + " bear is hunting for " + food + ".");
    }

    public void mate() {
        LOGGER.info("A " + this.type + " bear found a mate and will have cubs.");
    }
}