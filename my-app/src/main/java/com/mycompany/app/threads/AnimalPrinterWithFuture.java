package com.mycompany.app.threads;

import com.mycompany.app.abstracts.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AnimalPrinterWithFuture {
    private final ExecutorService executor;
    private static final Logger NEW_LOGGER = LogManager.getLogger(AnimalPrinterWithFuture.class);

    public AnimalPrinterWithFuture(int numOfAnimals) {
        this.executor = Executors.newFixedThreadPool(numOfAnimals);
    }

    public Future<String> printAnimal(Animal animal) throws InterruptedException {
        return this.executor.submit(animal::toString);
    }
}
