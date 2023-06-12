package com.mycompany.app.xml.domesticorwild;

import com.mycompany.app.models.Dog;
import com.mycompany.app.models.DomesticOrWild;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DomesticOrWildUnmarshaller {
    private static final Logger LOGGER = LogManager.getLogger(DomesticOrWildUnmarshaller.class);

    public static DomesticOrWild unmarshal(File file) {
        DomesticOrWild domesticOrWild = null;

        try {
            JAXBContext context = JAXBContext.newInstance(DomesticOrWild.class);
            domesticOrWild = (DomesticOrWild) context.createUnmarshaller().unmarshal(new FileReader(file));

            printDomesticOrWildInfo(domesticOrWild);
        }
        catch (JAXBException | FileNotFoundException e) {
            LOGGER.info(e);
        }

        return domesticOrWild;
    }

    public static void printDomesticOrWildInfo(DomesticOrWild domesticOrWild) {
        LOGGER.info("\nID: " + domesticOrWild.getDomesticOrWildID());
        LOGGER.info("Type: " + domesticOrWild.getDomesticOrWildType());
        LOGGER.info("Is Domesticated: " + domesticOrWild.isDomesticated());
        LOGGER.info("Animal ID: " + domesticOrWild.getAnimalID());
    }
}
