package com.mycompany.app.lambdas;

import com.mycompany.app.abstracts.Animal;
import com.mycompany.app.abstracts.WildAnimal;
import com.mycompany.app.animals.Dog;
import com.mycompany.app.enums.Sex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomLambdas {
    private static final Logger LOGGER = LogManager.getLogger(CustomLambdas.class);

    public static void doBigDogChecks(Dog dog) {
        IIsDogBig<Dog> iIsDogBig = (dog1) ->
                dog1.getBreed().name().equals("GERMANSHEPHERD") || dog1.getBreed().name().equals("GOLDENRETRIEVER");

        printDogResults(dog, iIsDogBig);
    }

    public static void printDogResults(Dog dog, IIsDogBig<Dog> iIsDogBig) {
        if(iIsDogBig.isDogBig(dog)) {
            LOGGER.info("A " + dog.getBreed().name() + " is big.");
        }
        else {
            LOGGER.info("A " + dog.getBreed().name() + " is not big.");
        }
    }

    public static void doCommonZooAnimalCheck(Animal animal) {
        IIsCommonZooAnimal<Animal> iIsCommonZooAnimal = (animal1) -> {
            return (animal1.getClass().getSuperclass().equals(WildAnimal.class) &&
                    !(animal1.getClass().getSimpleName().equals("Squirrel"))) ||
                    animal1.getClass().getSimpleName().equals("Bird");
        };

        printZooAnimalResults(animal, iIsCommonZooAnimal);
    }

    public static void printZooAnimalResults(Animal animal, IIsCommonZooAnimal<Animal> iIsCommonZooAnimal) {
        if(iIsCommonZooAnimal.isCommonZooAnimal(animal)) {
            LOGGER.info("A " + animal.getClass().getSimpleName() + " is probably going to be at a zoo.");
        }
        else {
            LOGGER.info("A " + animal.getClass().getSimpleName() + " is probably not going to be at a zoo.");
        }
    }

    public static void getMales(List<Animal> animals) {
        IMaleFilter<List<Animal>> maleFilter = list -> {
            list.stream().filter(animal -> animal.getSex() == Sex.MALE).forEach(animal ->
                LOGGER.info(animal.toString() + "     is a male."));
        };

        printMales(animals, maleFilter);
    }

    public static void printMales(List<Animal> animals, IMaleFilter<List<Animal>> maleFilter) {
        maleFilter.filterByAge(animals);
    }
}
