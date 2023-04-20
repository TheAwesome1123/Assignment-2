import domesticatedOrWild.*;
import pets.*;
import wildAnimals.*;

public class Main {
    public static void main(String[] args) {
        // New objects.
        Bear bear = new Bear("North America", "brown", "Brown", 2);
        Bird bird = new Bird(true, "Jack", "Parrot", 3, "Robert");
        Bird eagle = new Bird(false, "Unknown", "Bald Eagle", 4, "Robert");
        Cat cat = new Cat("Bob", "American Shorthair", 3, "Robert");
        Cat cat2 = new Cat("Bob", "American Shorthair", 3, "Robert");
        Dog germanShepherd = new Dog("Sam", "German Shepherd", 5, "Robert", false);
        Elephant elephant = new Elephant("Africa", "gray", 10, "Male");
        Horse horse = new Horse(true, "Bob", "American Belgian Draft", 5, "Robert");
        Rabbit rabbit = new Rabbit("Jerry", "American", 3, "Robert");
        Rhino rhino = new Rhino ("Africa", "gray", 1000);
        Rhino rhino2 = new Rhino ("Africa", "grey", 1000);
        Squirrel squirrel = new Squirrel("North America", "light brown", 1);
        Wolf wolf = new Wolf("North America", "light gray", 5);

        // Pets.
        cat.adopt();
        germanShepherd.adopt();
        rabbit.adopt();
        System.out.println();
        System.out.println("Is \"" + cat.toString() + "\" the same as \"" + cat2.toString() + "\" ? " + cat.equals(cat2) + "\n");
        System.out.println("Dog hash code: " + germanShepherd.hashCode() + "\n");
        System.out.println(rabbit.toString() + "\n");

        // Wild animals.
        System.out.println(bear.toString());
        bear.setNumCubs(6);
        System.out.println(bear.toString() + "\n");
        System.out.println("ELephant hash code: " + elephant.hashCode());
        elephant.eat();
        System.out.println();
        System.out.println("Is \"" + rhino.toString() + "\" the same as \"" + rhino2.toString() + "\" ? " + rhino.equals(rhino2) + "\n");
        System.out.println(squirrel.toString() + "\n");
        wolf.eat();
        System.out.println();

        // Domestic or wild animals.
        System.out.println(bird.toString());
        System.out.println("Bird hash code: " + bird.hashCode());
        bird.setOwner("N/A");
        System.out.println(bird.toString());
        System.out.println(eagle.toString()+ "\n");
        System.out.println(horse.toString());
        horse.setisDomesticated(false, "Robert");
        System.out.println(horse.toString());
    }
}