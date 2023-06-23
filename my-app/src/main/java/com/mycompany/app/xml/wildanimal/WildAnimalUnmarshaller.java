package com.mycompany.app.xml.wildanimal;

import com.mycompany.app.models.WildAnimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class WildAnimalUnmarshaller {
    private static final Logger LOGGER = LogManager.getLogger(WildAnimalUnmarshaller.class);

    public static WildAnimal unmarshal(File file) {
        WildAnimal wildAnimal = null;

        try {
            JAXBContext context = JAXBContext.newInstance(WildAnimal.class);
            wildAnimal = (WildAnimal) context.createUnmarshaller().unmarshal(new FileReader(file));

            printWildAnimalInfo(wildAnimal);
        }
        catch (JAXBException | FileNotFoundException e) {
            LOGGER.info(e);
        }

        return wildAnimal;
    }

    public static void printWildAnimalInfo(WildAnimal wildAnimal) {
        LOGGER.info("\nWild Animal");
        LOGGER.info("ID: " + wildAnimal.getWildAnimalID());
        LOGGER.info("Type: " + wildAnimal.getWildAnimalType());
        LOGGER.info("Animal ID: " + wildAnimal.getAnimalID());
    }
}
