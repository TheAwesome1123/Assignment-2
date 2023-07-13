package com.mycompany.app.designpattern;

import com.mycompany.app.models.Animal;
import com.mycompany.app.models.Pet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DesignPatternTesting {
    private static final Logger LOGGER = LogManager.getLogger(DesignPatternTesting.class);

    public static void testPatterns() {
        Animal animal = new AnimalBuilder().setID(5).setSex("Male").setType("Pet").buildAnimal();
        LOGGER.info(animal.getID());
        LOGGER.info(animal.getType());
        LOGGER.info(animal.getSex());

        Pet pet = new Pet();
        pet.setPetType("Dog");
        pet.setName("Bob");

        PetViewer petViewer = new PetViewer();
        PetController petController = new PetController(pet, petViewer);

        petController.printUpdatedPetInfo();
        pet.setAge(3);
        petController.printUpdatedPetInfo();
    }
}
