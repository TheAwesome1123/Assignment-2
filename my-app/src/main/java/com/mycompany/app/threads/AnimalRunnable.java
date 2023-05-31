package com.mycompany.app.threads;

import com.mycompany.app.abstracts.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnimalRunnable implements Runnable {
    private final Animal animal;

    public AnimalRunnable(Animal animal) {
        this.animal = animal;
    }
    private static final Logger NEW_LOGGER = LogManager.getLogger(AnimalPrinterWithFuture.class);
    public void run() {
        NEW_LOGGER.info("Getting animal info...");
        NEW_LOGGER.info(this.animal.toString());
    }
}
