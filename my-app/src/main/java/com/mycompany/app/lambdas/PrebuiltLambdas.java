package com.mycompany.app.lambdas;

import com.mycompany.app.abstracts.Animal;
import com.mycompany.app.animals.Cat;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;

public class PrebuiltLambdas {
    public static void calculateRatioBetweenAnimals(List<Animal> list1, List<Animal> list2, Logger logger) {
        DoubleBinaryOperator doubleBinaryOperator = (firstNum, secondNum) -> firstNum / secondNum;
        double ratio = doubleBinaryOperator.applyAsDouble(list1.size(), list2.size());

        logger.info("The ratio between a list of size " + list1.size() + " and one of size " + list2.size() +
                " is about " + ratio + ".");
    }

    public static void canDogsAndCatsFight(List<Animal> list, Logger logger) {
        Function<List<Animal>, Boolean> function = arraylist -> {
            int numCats = 0;
            int numDogs = 0;

            for (Animal animal : arraylist) {
                if (animal.getClass().getSimpleName().equals("Cat")) {
                    numCats++;
                } else if (animal.getClass().getSimpleName().equals("Dog")) {
                    numDogs++;
                }
            }

            return numCats >= 1 && numDogs >= 1;
        };

        printResultOfFight(list, function, logger);
    }

    public static void printResultOfFight(List<Animal> list, Function<List<Animal>, Boolean> function,
                                          Logger logger) {
        if(function.apply(list)) {
            logger.info("Dogs and cats can fight.");
        }
        else {
            logger.info("Not enough dogs and/or cats.");
        }
    }

    public static void areTwoCatBreedsTheSame(Cat cat1, Cat cat2, Logger logger) {
        BiFunction<Cat, Cat, Boolean> biFunction = (firstCat, secondCat) -> {
            return firstCat.getBreed().equals(secondCat.getBreed());
        };

        printResult(cat1, cat2, biFunction, logger);
    }

    public static void printResult(Cat cat1, Cat cat2, BiFunction<Cat, Cat, Boolean> biFunction, Logger logger) {
        if(biFunction.apply(cat1, cat2)) {
            logger.info("The breeds " + cat1.getBreed() + " and " + cat2.getBreed() + " are the same.");
        }
        else {
            logger.info("The breeds " + cat1.getBreed() + " and " + cat2.getBreed() + " are not the same.");
        }
    }
}
