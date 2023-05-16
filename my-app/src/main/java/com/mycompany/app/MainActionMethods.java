package com.mycompany.app;

import com.mycompany.app.animals.*;
import com.mycompany.app.exceptions.*;
import com.mycompany.app.lambdas.PrebuiltLambdas;
import org.apache.logging.log4j.Logger;

public class MainActionMethods {
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
        logger.info("Elephant hash code: " + elephant.hashCode());
        elephant.eat();
        logger.info("Is \"" + rhino.toString() + "\" the same as \"" + rhino2.toString() +
                "\" ? " + rhino.equals(rhino2) + "\n");
        logger.info(squirrel.toString() + "\n");
        wolf.eat();
        wolf.printStatement();
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
        catch(ThrowableInvalidPetActionException iae) {
            logger.info("ERROR!");
            logger.info(iae.reason + "\n");
        }

        try {
            bird.fly(100);
        }
        catch(ThrowableInvalidHeightException ihe) {
            logger.info("ERROR!");
            logger.info(ihe.reason + "\n");
        }

        try {
            horse.jump(4);
            horse.jump(-1);
        }
        catch(ThrowableInvalidNumFeetException infe) {
            logger.info("ERROR!");
            logger.info(infe.reason + "\n");
        }

        try {
            elephant.makeNoise("\"trumpeting\"");
            wolf.makeNoise("howling");
        }
        catch(ThrowableInvalidSoundException ise) {
            logger.info("ERROR!");
            logger.info(ise.reason + "\n");
        }

        try {
            elephant.lookForFood("plants");
        }
        catch(ThrowableInvalidFoodException ife) {
            logger.info("ERROR!");
            logger.info(ife.reason + "\n");
        }

        elephant.getHomeContinent().getRandomCountry();
        logger.info("Done.");
    }

    public static void prebuiltLambdaActions() {

    }
}
