package com.mycompany.app.threads;

import com.mycompany.app.ArrayListMethods;
import com.mycompany.app.abstracts.Animal;
import com.mycompany.app.animals.*;
import com.mycompany.app.enums.DogBreed;
import com.mycompany.app.enums.HomeContinent;
import com.mycompany.app.enums.Sex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadMain {
    private static final Logger NEW_LOGGER = LogManager.getLogger(ThreadMain.class);

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

        Animal[] animals = {dog1, dog2, elephant, wolf, squirrel, bird, horse};
        List<Animal> animalList = ArrayListMethods.makeArrayListFromArray(animals);

        future(animalList);
        NEW_LOGGER.info("");
        connectionPool(animalList);
        System.exit(0);
    }

    public static void future(List<Animal> list) {
        List<AnimalThreadWithFuture> inactiveConnections = new ArrayList<>();
        List<AnimalThreadWithFuture> activeConnections = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            inactiveConnections.add(new AnimalThreadWithFuture());
        }

        for (Animal animal : list) {
            if (inactiveConnections.size() > 0) {
                AnimalThreadWithFuture animalThreadWithFuture = inactiveConnections.get(0);
                activeConnections.add(animalThreadWithFuture);
                inactiveConnections.remove(animalThreadWithFuture);

                Future<String> animalInfo = animalThreadWithFuture.getAnimalInfoString(animal);
                inactiveConnections.add(animalThreadWithFuture);
                activeConnections.remove(animalThreadWithFuture);

                try {
                    NEW_LOGGER.info("Getting animal info...");
                    NEW_LOGGER.info(animalInfo.get());
                } catch (ExecutionException | InterruptedException e) {
                    NEW_LOGGER.info(e);
                }
            }
        }
    }

    public static void doFutureStuff(List<Animal> list) {
        InfoPrinterWithFuture infoPrinterWithFuture = new InfoPrinterWithFuture();

        for(Animal animal : list) {
            AnimalPrinterWithFuture stringToPrint = new AnimalPrinterWithFuture(list.size());

            try {
                Future<String> infoToPrint = infoPrinterWithFuture.getStringToPrint();
                Future<String> animalToPrint = stringToPrint.printAnimal(animal);

                Thread.sleep(300);
                NEW_LOGGER.info(infoToPrint.get());

                if(!(infoToPrint.isDone()) && animalToPrint.isDone()) {
                    NEW_LOGGER.info("Still waiting...");
                }
                else {
                    NEW_LOGGER.info(animalToPrint.get());
                }
            }
            catch(InterruptedException ie) {
                NEW_LOGGER.info("Interrupted; unable to get animal info.");
            }
            catch(ExecutionException ee) {
                NEW_LOGGER.info("Unable to get animal info.");
            }
        }
    }

    public static void connectionPool(List<Animal> list) {
        List<AnimalThread> inactiveConnections = new ArrayList<>();
        List<AnimalThread> activeConnections = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            inactiveConnections.add(new AnimalThread());
        }

        for (Animal animal : list) {
            if (inactiveConnections.size() > 0) {
                AnimalThread animalThread = inactiveConnections.get(0);
                inactiveConnections.remove(animalThread);
                activeConnections.add(animalThread);

                animalThread.run(animal);
                inactiveConnections.add(animalThread);
                activeConnections.remove(animalThread);
            }
        }
    }
}
