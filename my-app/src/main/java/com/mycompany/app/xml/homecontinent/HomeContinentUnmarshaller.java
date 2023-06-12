package com.mycompany.app.xml.homecontinent;

import com.mycompany.app.models.Dog;
import com.mycompany.app.models.HomeContinent;
import com.mycompany.app.xml.dog.DogUnmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class HomeContinentUnmarshaller {
    private static final Logger LOGGER = LogManager.getLogger(HomeContinentUnmarshaller.class);

    public static HomeContinent unmarshal(File file) {
        HomeContinent homeContinent = null;

        try {
            JAXBContext context = JAXBContext.newInstance(HomeContinent.class);
            homeContinent = (HomeContinent) context.createUnmarshaller().unmarshal(new FileReader(file));

            printHomeContinentInfo(homeContinent);
        }
        catch (JAXBException | FileNotFoundException e) {
            LOGGER.info(e);
        }

        return homeContinent;
    }

    public static void printHomeContinentInfo(HomeContinent homeContinent) {
        LOGGER.info("\nID: " + homeContinent.getContinentID());
        LOGGER.info("Continent: " + homeContinent.getContinent());
        LOGGER.info("Wild Animal ID: " + homeContinent.getWildAnimalID());
    }
}
