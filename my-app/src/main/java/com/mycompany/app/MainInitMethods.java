package com.mycompany.app;

import com.mycompany.app.abstracts.Animal;
import com.mycompany.app.animals.*;
import com.mycompany.app.enums.*;
import com.mycompany.app.lambdas.PrebuiltLambdas;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class MainInitMethods {
    public static void makeAnimals(Logger logger) {
        // New objects.
        Bear bear = new Bear(Sex.FEMALE, HomeContinent.NORTHAMERICA, "brown", BearType.BROWN, 2);
        Bird bird = new Bird(true, Sex.MALE, "Jack", "Parrot", 3, "Robert");
        Bird eagle = new Bird(false, Sex.FEMALE, "Unknown", "Bald Eagle", 4,
                "N/A");
        Cat cat = new Cat("Bob", CatBreed.AMERICANSHORTHAIR, Sex.MALE, 3, "Robert");
        Cat cat2 = new Cat("Bob", CatBreed.AMERICANSHORTHAIR, Sex.MALE, 3, "Robert");
        Dog germanShepherd = new Dog("Sam", DogBreed.GERMANSHEPHERD, Sex.MALE, 5, "Robert",
                false);
        Elephant elephant = new Elephant(Sex.FEMALE, HomeContinent.AFRICA, "gray", 10);
        Horse horse = new Horse(true, Sex.MALE, "Bob", "American Belgian Draft", 5,
                "Robert");
        Rabbit rabbit = new Rabbit("Jerry", RabbitBreed.AMERICAN, Sex.MALE, 3, "Robert");
        Rhino rhino = new Rhino (Sex.FEMALE, HomeContinent.AFRICA, "gray", 1000);
        Rhino rhino2 = new Rhino (Sex.FEMALE, HomeContinent.AFRICA, "grey", 1000);
        Squirrel squirrel = new Squirrel(Sex.MALE, HomeContinent.NORTHAMERICA,
                "light brown", 1);
        Wolf wolf = new Wolf(Sex.FEMALE, HomeContinent.NORTHAMERICA, "light gray", 5);

        // Store all animals together.
        Animal[] animals = {bear, bird, eagle, cat, cat2, germanShepherd, elephant, horse, rabbit, rhino, rhino2,
            squirrel, wolf};

        List<Animal> arrayList = ArrayListMethods.makeArrayListFromArray(animals);

        makeArrayListsByAnimalType(arrayList, logger);

        // Pets.
        logger.info("-----------------");
        MainActionMethods.doPetStuff(cat, cat2, germanShepherd, rabbit, logger);
        logger.info("-----------------");

        // Wild animals.
        MainActionMethods.doWildAnimalStuff(bear, elephant, rhino, rhino2, squirrel, wolf, logger);
        logger.info("-----------------");

        // Domestic or wild animals.
        MainActionMethods.doDomesticOrWildAnimalStuff(bird, eagle, horse, logger);
        logger.info("-----------------");

        // Interface methods.
        MainActionMethods.interfaceMethods(cat2, germanShepherd, rabbit, bird, horse, elephant, wolf, logger);

        PrebuiltLambdas.canDogsAndCatsFight(arrayList, logger);
        PrebuiltLambdas.areTwoCatBreedsTheSame(cat, cat2, logger);
    }

    public static void makeArrayListsByAnimalType(List<Animal> list, Logger logger) {
            // ArrayLists.
            List<Animal> pets = new ArrayList<>();
            List<Animal> wildAnimals = new ArrayList<>();
            List<Animal> domesticOrWildAnimals = new ArrayList<>();
            List<Animal> carnivores = new ArrayList<>();
            List<Animal> zooAnimals = new ArrayList<>();

            ArrayListMethods.initAddToArrayLists(list, pets, wildAnimals, domesticOrWildAnimals, carnivores,
                zooAnimals, logger);

            logger.info("");
            MainInitMethods.makeLinkedList(pets, wildAnimals, domesticOrWildAnimals, logger);
            logger.info("");

            PrebuiltLambdas.calculateRatioBetweenAnimals(pets, list, logger);
    }

    public static void makeLinkedList(List<Animal> pets, List<Animal> wildAnimals,
        List<Animal> domesticOrWildAnimals, Logger logger) {
            // Linked list.
            LinkedListNode<Animal> first = new LinkedListNode<>(pets.get(0),
                    pets.get(0).getClass().getName(), null, null, logger);

            for(int i = 1; i < pets.size(); i++) {
                first.addNode(pets.get(i), pets.get(i).getClass().getSimpleName());
            }

            for (Animal wildAnimal : wildAnimals) {
                first.addNode(wildAnimal, wildAnimal.getClass().getSimpleName());
            }

            for (Animal domesticOrWildAnimal : domesticOrWildAnimals) {
                first.addNode(domesticOrWildAnimal, domesticOrWildAnimal.getClass().getSimpleName());
            }

            first.printList();
            logger.info("Deleting Horse.");
            first = first.deleteNode("Horse");
            logger.info("Deleting Cat.");
            LinkedListNode<Animal> newList = first.deleteNode("Cat");
            newList.printList();
            logger.info("");
            first.printClasses(logger);
    }
}
