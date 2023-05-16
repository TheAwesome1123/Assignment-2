package com.mycompany.app.animals;

import com.mycompany.app.enums.RabbitBreed;
import org.apache.logging.log4j.*;
import com.mycompany.app.abstracts.*;
import com.mycompany.app.exceptions.ThrowableInvalidSoundException;
import com.mycompany.app.enums.Sex;

public class Rabbit extends Pet {
    // Properties.
    private static final boolean needsCage = true;
    private RabbitBreed breed;

    // Constructor.
    public Rabbit(String name, RabbitBreed breed, Sex sex, int age, String owner) {
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
        this.owner = owner;
    }

    // Getters/setters.
    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public RabbitBreed getBreed() {
        return this.breed;
    }

    public void setBreed(RabbitBreed newBreed) {
        this.breed = newBreed;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public boolean getNeedsCage() {
        return needsCage;
    }
    
    // Other methods.
    public void adopt() {
        LOGGER.info("A " + this.breed + " rabbit named " + this.name + " was adopted by " + this.owner + ".");
    }

    public String toString() {
        return "Rabbit Name: " + this.name + ", Breed: " + this.breed + ", Sex: " + this.sex + ", Age: " + this.age +
            ", Owner: " + this.owner;
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
        LOGGER.info("A " + this.breed + " rabbit named " + this.name + " is eating.");
    }

    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        super.makeNoise(noise);
        LOGGER.info("A " + this.breed + " rabbit named " + this.name + " is making a " + noise + " sound.");
    }

    public void pet() {
        LOGGER.info(this.owner + " is petting a " + this.breed + " rabbit named " + this.name + ".");
    }
}