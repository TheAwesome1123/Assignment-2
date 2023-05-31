package com.mycompany.app.threads;

import com.mycompany.app.abstracts.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnimalThread extends Thread {
    private static final Logger NEW_LOGGER = LogManager.getLogger(AnimalThread.class);

    public void run(Animal animal) {
        NEW_LOGGER.info("Getting animal info...");
        NEW_LOGGER.info(animal.toString());
    }
}
