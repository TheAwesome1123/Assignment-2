package com.mycompany.app.animals;

import com.mycompany.app.enums.CatBreed;
import com.mycompany.app.enums.Sex;
import org.apache.logging.log4j.*;
import com.mycompany.app.abstracts.*;
import com.mycompany.app.exceptions.ThrowableInvalidSoundException;

public class Cat extends Pet {
    // Properties.
    private CatBreed breed;

    // Constructor.
    public Cat(String name, CatBreed breed, Sex sex, int age, String owner) {
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

    public CatBreed getBreed() {
        return this.breed;
    }

    public void setBreed(CatBreed newBreed) {
        this.breed = newBreed;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    // Other methods.
    public void adopt() {
        LOGGER.info("A " + this.breed + " cat named " + this.name + " was adopted by " + this.owner + ".");
    }

    public String toString() {
        return "Cat Name: " + this.name + ", Breed: " + this.breed + ", Sex: " + this.sex + ", Age: " + this.age +
            ", Owner: " + this.owner;
    }

    public boolean equals(Cat catToCompareWith) {
        if(this.name.equals(catToCompareWith.name) && this.breed.equals(catToCompareWith.breed) && 
            this.age == catToCompareWith.age && this.owner.equals(catToCompareWith.owner)) {
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
        LOGGER.info("A " + this.breed + " cat named " + this.name + " is eating.");
    }

    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        super.makeNoise(noise);
        LOGGER.info("A " + this.breed + " cat named " + this.name + " is making a " + noise + " sound.");
    }

    public void pet() {
        LOGGER.info(this.owner + " is petting a " + this.breed + " cat named " + this.name + ".");
    }
}