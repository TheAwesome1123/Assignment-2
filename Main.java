import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.*; // https://sematext.com/blog/log4j2-tutorial/
import abstracts.*;
import animals.*;
import exceptions.*;

public class Main {
    private static final Logger NEW_LOGGER = LogManager.getLogger("Logger");

    static {
        NEW_LOGGER.info("Starting.");
        NEW_LOGGER.info("Welcome; please follow the next prompt.");
    }

    public static void main(String[] args) {
        // Start.
        int input = 0;
        NEW_LOGGER.info("Press 1 to continue: ");
        Scanner scanner = new Scanner(System.in);

        try {
            input = scanner.nextInt();
        }
        catch(InputMismatchException ime) {
            NEW_LOGGER.info("Invalid input; quitting.");
            scanner.close();
            return;
        }
        
        if(input == 1) {
            printDetails();
            NEW_LOGGER.info("Making animals.");
            makeAnimals(NEW_LOGGER);
        }
        else {
            NEW_LOGGER.info("Input wasn't 1; quitting.");
        }
        
        scanner.close();
        return;
    }

    public static void printDetails() {
        NEW_LOGGER.info("Order of operations:");
        NEW_LOGGER.info("1. Create animal objects (not shown here).");
        NEW_LOGGER.info("2. Use methods in animal classes.");
        NEW_LOGGER.info("3. Use interface methods.");
        NEW_LOGGER.info("-----------------");
    }

    public static void makeAnimals(Logger logger) {
        // New objects.
        Bear bear = new Bear("North America", "brown", "Brown", 2, NEW_LOGGER);
        Bird bird = new Bird(true, "Jack", "Parrot", 3, "Robert", NEW_LOGGER);
        Bird eagle = new Bird(false, "Unknown", "Bald Eagle", 4, "Robert", NEW_LOGGER);
        Cat cat = new Cat("Bob", "American Shorthair", 3, "Robert", NEW_LOGGER);
        Cat cat2 = new Cat("Bob", "American Shorthair", 3, "Robert", NEW_LOGGER);
        Dog germanShepherd = new Dog("Sam", "German Shepherd", 5, "Robert", false, NEW_LOGGER);
        Elephant elephant = new Elephant("Africa", "gray", 10, "Male", NEW_LOGGER);
        Horse horse = new Horse(true, "Bob", "American Belgian Draft", 5, "Robert", NEW_LOGGER);
        Rabbit rabbit = new Rabbit("Jerry", "American", 3, "Robert", NEW_LOGGER);
        Rhino rhino = new Rhino ("Africa", "gray", 1000, NEW_LOGGER);
        Rhino rhino2 = new Rhino ("Africa", "grey", 1000, NEW_LOGGER);
        Squirrel squirrel = new Squirrel("North America", "light brown", 1, NEW_LOGGER);
        Wolf wolf = new Wolf("North America", "light gray", 5, NEW_LOGGER);

        // ArrayLists.
        ArrayList<Pet> pets = new ArrayList<Pet>();
        ArrayList<WildAnimal> wildAnimals = new ArrayList<WildAnimal>();
        ArrayList<DomesticatedOrWild> domesticOrWildAnimals = new ArrayList<DomesticatedOrWild>();
        ArrayList<Animal> carnivores = new ArrayList<Animal>();
        ArrayList<Animal> zooAnimals = new ArrayList<Animal>();

        pets.add(cat);
        pets.add(cat2);
        pets.add(germanShepherd);
        pets.add(rabbit);

        wildAnimals.add(bear);
        wildAnimals.add(elephant);
        wildAnimals.add(rhino);
        wildAnimals.add(rhino2);
        wildAnimals.add(squirrel);
        wildAnimals.add(wolf);

        domesticOrWildAnimals.add(bird);
        domesticOrWildAnimals.add(eagle);
        domesticOrWildAnimals.add(horse);

        carnivores.add(bear);
        carnivores.add(wolf);

        zooAnimals.add(bear);
        zooAnimals.add(bird);
        zooAnimals.add(elephant);
        zooAnimals.add(rhino);
        zooAnimals.add(rhino2);
        zooAnimals.add(wolf);


        NEW_LOGGER.info("Num of pets: " + pets.size() + ".");
        NEW_LOGGER.info("Num of wild animals: " + wildAnimals.size() + ".");
        NEW_LOGGER.info("Num of domestic/wild animals: " + domesticOrWildAnimals.size() + ".");
        NEW_LOGGER.info("Number of carnivores: " + carnivores.size() + ".\n");

        NEW_LOGGER.info("Animals that can be found at zoos: ");
        for (Animal animal : zooAnimals) {
            NEW_LOGGER.info(animal.getClass().getName() + " ");
        }

        // Linked list.
        LinkedListNode<Animal> first = new LinkedListNode<Animal>(pets.get(0), 
            pets.get(0).getClass().getName(), null, null, NEW_LOGGER);
        
        for(int i = 1; i < pets.size(); i++) {
            first.addNode(pets.get(i), pets.get(i).getClass().getSimpleName());
        }

        for(int i = 0; i < wildAnimals.size(); i++) {
            first.addNode(wildAnimals.get(i), wildAnimals.get(i).getClass().getSimpleName());
        }

        for(int i = 0; i < domesticOrWildAnimals.size(); i++) {
            first.addNode(domesticOrWildAnimals.get(i), domesticOrWildAnimals.get(i).getClass().getSimpleName());
        }

        first.printList();
        first = first.deleteNode("Horse");
        first.printList();
        LinkedListNode<Animal> newList = first.deleteNode("Cat");
        NEW_LOGGER.info("Deleting cat.");
        newList.printList();

        // Pets.
        doPetStuff(cat, cat2, germanShepherd, rabbit, NEW_LOGGER);
        NEW_LOGGER.info("-----------------");


        // Wild animals.
        doWildAnimalStuff(bear, elephant, rhino, rhino2, squirrel, wolf, NEW_LOGGER);
        NEW_LOGGER.info("-----------------");


        // Domestic or wild animals.
        doDomesticOrWildAnimalStuff(bird, eagle, horse, NEW_LOGGER);
        NEW_LOGGER.info("-----------------");

        // Interface methods.
        interfaceMethods(cat2, germanShepherd, rabbit, bird, horse, elephant, wolf, NEW_LOGGER);
    }

    public static void doPetStuff(Cat cat, Cat cat2, Dog dog, Rabbit rabbit, Logger logger) {
        cat.adopt();
        dog.adopt();
        rabbit.adopt();
        logger.info("\nIs \"" + cat.toString() + "\" the same as \"" + cat.toString() + "\" ? " + cat.equals(cat2) + "\n");
        logger.info("Dog hash code: " + dog.hashCode() + "\n");
        logger.info(rabbit.toString());
    }

    public static void doWildAnimalStuff(Bear bear, Elephant elephant, Rhino rhino, Rhino rhino2, 
        Squirrel squirrel, Wolf wolf, Logger logger) {
            logger.info(bear.toString());
            bear.setNumCubs(6);
            logger.info(bear.toString() + "\n");
            logger.info("ELephant hash code: " + elephant.hashCode());
            elephant.eat();
            logger.info("\n");
            logger.info("Is \"" + rhino.toString() + "\" the same as \"" + rhino2.toString() + 
                "\" ? " + rhino.equals(rhino2) + "\n");
                logger.info(squirrel.toString() + "\n");
            wolf.eat();
            wolf.printStatement();
            logger.info("\n");
    }

    public static void doDomesticOrWildAnimalStuff(Bird bird, Bird bird2, Horse horse, Logger logger) {
        logger.info(bird.toString());
        logger.info("Bird hash code: " + bird.hashCode());
        bird.setOwner("N/A");
        logger.info(bird.toString());
        logger.info(bird2.toString()+ "\n");
        logger.info(horse.toString());
        horse.setisDomesticated(false, "Robert");
        logger.info(horse.toString());
    }

    public static void interfaceMethods(Cat cat, Dog dog, Rabbit rabbit, Bird bird, Horse horse, Elephant elephant, Wolf wolf, 
        Logger logger) {
        cat.eat();

        try {
            dog.teach("fetch");
            cat.teach("");
            rabbit.teach("How to show its moves.");
        }
        catch(InvalidPetActionException iae) {
            logger.info("ERROR!");
            logger.info(iae.reason + "\n");
        }

        try {
            bird.fly(100);
        }
        catch(InvalidHeightException ihe) {
            logger.info("ERROR!");
            logger.info(ihe.reason + "\n");
        }

        try {
            horse.jump(4);
            horse.jump(-1);
        }
        catch(InvalidNumFeetException infe) {
            logger.info("ERROR!");
            logger.info(infe.reason + "\n");
        }

        try {
            elephant.makeNoise("\"trumpeting\"");
            wolf.makeNoise("howling");
        }
        catch(InvalidSoundException ise) {
            logger.info("ERROR!");
            logger.info(ise.reason + "\n");
        }

        try {
            elephant.lookForFood("plants");
        }
        catch(InvalidFoodException ife) {
            logger.info("ERROR!");
            logger.info(ife.reason + "\n");
        }   

        logger.info("Done.");
    }
}