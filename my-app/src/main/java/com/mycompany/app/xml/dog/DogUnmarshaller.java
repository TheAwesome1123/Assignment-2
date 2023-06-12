package com.mycompany.app.xml.dog;

import com.mycompany.app.models.Dog;
import com.mycompany.app.models.Pet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DogUnmarshaller {
    private static final Logger LOGGER = LogManager.getLogger(DogUnmarshaller.class);

    public static Dog unmarshal(File file) {
        Dog dog = null;

        try {
            JAXBContext context = JAXBContext.newInstance(Dog.class);
            dog = (Dog) context.createUnmarshaller().unmarshal(new FileReader(file));

            printDogInfo(dog);
        }
        catch (JAXBException | FileNotFoundException e) {
            LOGGER.info(e);
        }

        return dog;
    }

    public static void printDogInfo(Dog dog) {
        LOGGER.info("\nID: " + dog.getDogID());
        LOGGER.info("Breed: " + dog.getBreed());
        LOGGER.info("Pet ID: " + dog.getPetID());
    }
}
