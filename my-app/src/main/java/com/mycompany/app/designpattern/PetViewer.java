package com.mycompany.app.designpattern;

import com.mycompany.app.models.Pet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PetViewer {
    private static final Logger LOGGER = LogManager.getLogger(PetViewer.class);

    public void printPetInfo(Pet pet) {
        LOGGER.info("Pet type: " + pet.getPetType());
        LOGGER.info("Pet name: " + pet.getName());
        LOGGER.info("Pet age: " + pet.getAge());
    }
}
