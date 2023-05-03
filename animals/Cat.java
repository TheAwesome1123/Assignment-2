package animals;
import org.apache.logging.log4j.*;
import exceptions.InvalidSoundException;
import abstracts.*;

public class Cat extends Pet {
    // Properties.
    private Logger logger;

    // Constructor.
    public Cat(String name, String breed, int age, String owner, Logger logger) {
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

    // Other methods.
    public void adopt() {
        logger.info("A " + this.breed + " cat named " + this.name + " was adopted by " + this.owner + ".");
    }

    public String toString() {
        return "Cat Name: " + this.name + ", Breed: " + this.breed + ", Age: " + this.age + ", Owner: " + this.owner;
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
        logger.info("A " + this.breed + " cat named " + this.name + " is eating.");
    }

    public void makeNoise(String noise) throws InvalidSoundException {
        super.makeNoise(noise);
        logger.info("A " + this.breed + " cat named " + this.name + " is making a " + noise + " sound.");
    }

    public void pet() {
        logger.info(this.owner + " is petting a " + this.breed + " cat named " + this.name + ".");
    }
}