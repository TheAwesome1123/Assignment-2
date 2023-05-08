package com.mycompany.app.animals;

import org.apache.logging.log4j.*;
import com.mycompany.app.abstracts.*;
import com.mycompany.app.exceptions.ThrowableInvalidSoundException;

public class Rabbit extends Pet {
    // Properties.
    private final boolean needsCage = true;
    private Logger logger;

    // Constructor.
    public Rabbit(String name, String breed, int age, String owner, Logger logger) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
        this.logger = logger;
    }

    // Getters/setters.
    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String newBreed) {
        this.breed = newBreed;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String newOwner) {
        this.owner = newOwner;
    }

    public boolean getNeedsCage() {
        return this.needsCage;
    }
    
    // Other methods.
    public void adopt() {
        logger.info("A " + this.breed + " rabbit named " + this.name + " was adopted by " + this.owner + ".");
    }

    public String toString() {
        return "Rabbit Name: " + this.name + ", Breed: " + this.breed + ", Age: " + this.age + ", Owner: " + this.owner;
    }

    public boolean equals(Rabbit rabbitToCompareWith) {
        if(this.name.equals(rabbitToCompareWith.name) && this.breed.equals(rabbitToCompareWith.breed) && 
            this.age == rabbitToCompareWith.age && this.owner.equals(rabbitToCompareWith.owner)) {
                return true;
        }
        else {
            return false;
        }
    }

    public int hashCode() {
        int result = 1000;
        result *= this.name.hashCode();
        result += this.age;
        return result;
    }

    public void eat() {
        logger.info("A " + this.breed + " rabbit named " + this.name + " is eating.");
    }

    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        super.makeNoise(noise);
        logger.info("A " + this.breed + " rabbit named " + this.name + " is making a " + noise + " sound.");
    }

    public void pet() {
        logger.info(this.owner + " is petting a " + this.breed + " rabbit named " + this.name + ".");
    }
}