package com.mycompany.app.animals;

import com.mycompany.app.enums.DogBreed;
import com.mycompany.app.abstracts.*;
import com.mycompany.app.exceptions.ThrowableInvalidSoundException;
import com.mycompany.app.enums.Sex;

public class Dog extends Pet {
    // Properties.
    private boolean fightsWithCats;
    private DogBreed breed;
    private static final int numOfLegs = 4;

    // Constructor.
    public Dog(String name, DogBreed breed, Sex sex, int age, String owner, boolean fightsWithCats) {
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
        this.owner = owner;
        this.fightsWithCats = fightsWithCats;
    }

    // Getters/setters.
    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public DogBreed getBreed() {
        return this.breed;
    }

    public void setBreed(DogBreed newBreed) {
        this.breed = newBreed;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public boolean getFightingWithCatsHabit() {
        return this.fightsWithCats;
    }

    public void setFightingWithCatsHabit(boolean habit) {
        this.fightsWithCats = habit;
    }

    public static int getNumOfLegs() {
        return numOfLegs;
    }

    // Other methods.
    public void adopt() {
        LOGGER.info("A " + this.breed + " dog named " + this.name + " was adopted by " + this.owner + ".");
    }

    public String toString() {
        return "Dog Name: " + this.name + ", Breed: " + this.breed + ", Sex: " + this.sex + ", Age: " + this.age +
            ", Owner: " + this.owner + ", Fights with cats: " + this.fightsWithCats;
    }

    public boolean equals(Dog dogToCompareWith) {
        if(this.name.equals(dogToCompareWith.name) && this.breed.equals(dogToCompareWith.breed) && 
            this.age == dogToCompareWith.age && this.owner.equals(dogToCompareWith.owner) && 
            this.fightsWithCats == dogToCompareWith.fightsWithCats) {
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
        LOGGER.info("A " + this.breed + " dog named " + this.name + " is eating.");
    }

    public void makeNoise(String noise) throws ThrowableInvalidSoundException {
        super.makeNoise(noise);
        LOGGER.info("A " + this.breed + " dog named " + this.name + " is making a " + noise + " sound.");
    }

    public void pet() {
        LOGGER.info(this.owner + " is petting a " + this.breed + " dog named " + this.name + ".");
    }
}