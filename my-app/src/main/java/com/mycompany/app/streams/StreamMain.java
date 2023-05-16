package com.mycompany.app.streams;

import com.mycompany.app.ArrayListMethods;
import com.mycompany.app.abstracts.Animal;
import com.mycompany.app.abstracts.Pet;
import com.mycompany.app.abstracts.WildAnimal;
import com.mycompany.app.animals.*;
import com.mycompany.app.enums.DogBreed;
import com.mycompany.app.enums.HomeContinent;
import com.mycompany.app.enums.Sex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamMain {
    private static final Logger LOGGER = LogManager.getLogger(StreamMain.class);

    public static void main(String[] args) {
        Dog dog1 = new Dog("Sam", DogBreed.BEAGLE, Sex.MALE, 5, "N/A",
                true);
        Dog dog2 = new Dog("Max", DogBreed.GOLDENRETRIEVER, Sex.MALE, 2, "Robert",
                false);

        Elephant elephant = new Elephant(Sex.MALE, HomeContinent.AFRICA, "Grey", 10);
        Wolf wolf = new Wolf(Sex.FEMALE, HomeContinent.NORTHAMERICA, "Light grey", 3);
        Squirrel squirrel = new Squirrel(Sex.FEMALE, HomeContinent.EUROPE, "Brown", 2);

        Bird bird = new Bird(false, Sex.MALE, "??", "Bald Eagle", 4, "N/A");
        Horse horse = new Horse(true, Sex.FEMALE, "Emma", "American Belgian Draft", 3,
            "Robert");

        Animal[] animalArray = {dog1, dog2, elephant, wolf, squirrel, bird, horse};
        List<Animal> allAnimals = ArrayListMethods.makeArrayListFromArray(animalArray);

        List<Pet> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);

        List<WildAnimal> wildAnimals = new ArrayList<>();
        wildAnimals.add(elephant);
        wildAnimals.add(wolf);
        wildAnimals.add(squirrel);

        testStreams(allAnimals, dogs, wildAnimals, dog1, horse);

    }

    public static void testStreams(List<Animal> animals, List<Pet> dogs, List<WildAnimal> wildAnimals, Dog dog,
        Horse horse) {

            GiveOwnerToPetsWithoutOne.giveOwnerToPetWithoutOne(dogs, "Rob");
            System.out.println(dog.toString());
            LOGGER.info("");

            AreThereNoWildAnimalsInAntarctica.areThereNoWildAnimalsInAntarctica(wildAnimals);
            LOGGER.info("");

            LOGGER.info("First 2 animals: ");
            GetFirstXAnimalsInList.getFirstXAnimalsInList(animals, 2);
            LOGGER.info("");

            LOGGER.info(AreAnimalsInListUnique.resultOfThereBeingUniqueAnimals(animals));
            LOGGER.info("Adding animal.");
            animals.add(horse);
            LOGGER.info(AreAnimalsInListUnique.resultOfThereBeingUniqueAnimals(animals));
            LOGGER.info("");

            Optional<Animal> randomAnimalOptional= GetSomeAnimalFromList.getAnimalFromList(animals);

            if(randomAnimalOptional.isPresent()) {
                LOGGER.info(randomAnimalOptional.get().toString());
            }
            else {
                LOGGER.info("Somehow, no animal was returned.");
            }
    }
}
