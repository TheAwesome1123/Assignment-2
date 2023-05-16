package com.mycompany.app.animals;

import com.mycompany.app.enums.HomeContinent;
import org.apache.logging.log4j.*;

import com.mycompany.app.abstracts.WildAnimal;
import com.mycompany.app.exceptions.*;
import com.mycompany.app.enums.Sex;

public class Squirrel extends WildAnimal {
    // Properties.
    private int numOfVisitsToHousePerDay;

    // Constructor.
    public Squirrel(Sex sex, HomeContinent homeContinent, String color, int numOfVisitsToHousePerDay) {
        this.sex = sex;
        this.homeContinent = homeContinent;
        this.color = color;
        this.numOfVisitsToHousePerDay = numOfVisitsToHousePerDay;
    }

    // Getters/setters.
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
        return "Squirrel Sex: " + this.sex + ", Home Continent: " + this.homeContinent + ", Color: " + this.color +
            ", Number of Visits to a House per Day: " + this.numOfVisitsToHousePerDay;
    }

    public int hashCode() {
        int result = 1000;
        result *= this.color.hashCode();
        result += this.numOfVisitsToHousePerDay;
        return result;
    }

    public void eat() {
        LOGGER.info("A " + this.color + " squirrel is eating nuts.");
    }

    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        super.makeNoise(noise);
        LOGGER.info("A " + this.color + " squirrel is making a " + noise + " sound.");
    }

    public void lookForFood(String food) throws ThrowableInvalidFoodException {
        super.lookForFood(food);
        LOGGER.info("A " + this.color + " squirrel is looking for ." + food + ".");
    }

    public void mate() {
        LOGGER.info("A " + this.color + " squirrel is mating.");
    }
}