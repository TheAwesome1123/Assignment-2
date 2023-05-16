package com.mycompany.app;

import com.mycompany.app.abstracts.Animal;
import com.mycompany.app.animals.*;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ArrayListMethods {
    public static void addToList(List<Animal> list, List<Animal> listToAddTo, Predicate<Animal> p) {
        for (Animal animal: list) {
            if(p.test(animal)) {
                listToAddTo.add(animal);
            }
        }
    }

    public static List<Animal> makeArrayListFromArray(Animal[] array) {

        return new ArrayList<>(Arrays.asList(array));
    }

    public static void initAddToArrayLists(List<Animal> allAnimalsMade, List<Animal> pets,
        List<Animal> wildAnimals, List<Animal> domesticOrWildAnimals, List<Animal> carnivores,
        List<Animal> zooAnimals, Logger logger) {
            // Lambdas with conditions; pets, wild animals, and domestic/wild animals.
            Predicate<Animal> allPets = animal -> animal.getClass().getSuperclass().getSimpleName().equals("Pet");
            Predicate<Animal> allWildAnimals = animal ->
                    animal.getClass().getSuperclass().getSimpleName().equals("WildAnimal");
            Predicate<Animal> allDomesticOrWildAnimals = animal ->
                    animal.getClass().getSuperclass().getSimpleName().equals("DomesticatedOrWild");

            ArrayListMethods.addToList(allAnimalsMade, pets, allPets);
            ArrayListMethods.addToList(allAnimalsMade, wildAnimals, allWildAnimals);
            ArrayListMethods.addToList(allAnimalsMade, domesticOrWildAnimals, allDomesticOrWildAnimals);

            // Carnivores.
            for(Animal animal: allAnimalsMade) {
                if(animal.getClass().equals(Bear.class) || animal.getClass().equals(Wolf.class)) {
                    carnivores.add(animal);
                }
            }

            // Zoo animals.
            for(Animal animal: allAnimalsMade) {
                if(animal.getClass().equals(Bear.class) || animal.getClass().equals(Bird.class) ||
                    animal.getClass().equals(Elephant.class) || animal.getClass().equals(Rhino.class) ||
                    animal.getClass().equals(Wolf.class)) {
                        carnivores.add(animal);
                }
            }

            logger.info("Num of pets: " + pets.size() + ".");
            logger.info("Num of wild animals: " + wildAnimals.size() + ".");
            logger.info("Num of domestic/wild animals: " + domesticOrWildAnimals.size() + ".");
            logger.info("Number of carnivores: " + carnivores.size() + ".\n");
            logger.info("Animals that can be found at zoos: ");

            for (Animal animal : zooAnimals) {
                logger.info(animal.getClass().getSimpleName() + " ");
            }

            logger.info("");
    }
}
