package com.mycompany.app.xml.domesticorwild;

import com.mycompany.app.models.DomesticOrWildAnimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DomesticOrWildUnmarshaller {
    private static final Logger LOGGER = LogManager.getLogger(DomesticOrWildUnmarshaller.class);

    public static DomesticOrWildAnimal unmarshal(File file) {
        DomesticOrWildAnimal domesticOrWildAnimal = null;

        try {
            JAXBContext context = JAXBContext.newInstance(DomesticOrWildAnimal.class);
            domesticOrWildAnimal = (DomesticOrWildAnimal) context.createUnmarshaller().unmarshal(new FileReader(file));

            printDomesticOrWildInfo(domesticOrWildAnimal);
        }
        catch (JAXBException | FileNotFoundException e) {
            LOGGER.info(e);
        }

        return domesticOrWildAnimal;
    }

    public static void printDomesticOrWildInfo(DomesticOrWildAnimal domesticOrWildAnimal) {
        LOGGER.info("\nDomestic or Wild Animal");
        LOGGER.info("ID: " + domesticOrWildAnimal.getDomesticOrWildID());
        LOGGER.info("Type: " + domesticOrWildAnimal.getDomesticOrWildType());
        LOGGER.info("Is Domesticated: " + domesticOrWildAnimal.isDomesticated());
        LOGGER.info("Animal ID: " + domesticOrWildAnimal.getAnimalID());
    }
}
