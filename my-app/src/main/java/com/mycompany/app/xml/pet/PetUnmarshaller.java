package com.mycompany.app.xml.pet;

import com.mycompany.app.models.Pet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PetUnmarshaller {
    private static final Logger LOGGER = LogManager.getLogger(PetUnmarshaller.class);

    public static Pet unmarshal(File file) {
        Pet pet = null;

        try {
            JAXBContext context = JAXBContext.newInstance(Pet.class);
            pet = (Pet) context.createUnmarshaller().unmarshal(new FileReader(file));

            printPetInfo(pet);
        }
        catch (JAXBException | FileNotFoundException e) {
            LOGGER.info(e);
        }

        return pet;
    }

    public static void printPetInfo(Pet pet) {
        LOGGER.info("\nPet");
        LOGGER.info("ID: " + pet.getPetID());
        LOGGER.info("Type: " + pet.getPetType());
        LOGGER.info("Name: " + pet.getName());

        String date = new DateOfBirthAdapter().marshal(pet.getDateOfBirth());
        LOGGER.info("Date of Birth: " + date);

        LOGGER.info("Owner ID: " + pet.getOwnerID());
        LOGGER.info("Animal ID: " + pet.getAnimalID());
    }
}
