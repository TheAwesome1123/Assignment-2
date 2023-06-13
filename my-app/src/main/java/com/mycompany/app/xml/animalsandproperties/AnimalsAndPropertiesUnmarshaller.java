package com.mycompany.app.xml.animalsandproperties;

import com.mycompany.app.models.HomeContinent;
import com.mycompany.app.xml.dog.DogUnmarshaller;
import com.mycompany.app.xml.domesticorwild.DomesticOrWildUnmarshaller;
import com.mycompany.app.xml.homecontinent.HomeContinentUnmarshaller;
import com.mycompany.app.xml.pet.PetUnmarshaller;
import com.mycompany.app.xml.wildanimal.WildAnimalUnmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AnimalsAndPropertiesUnmarshaller {
    private static final Logger LOGGER = LogManager.getLogger(HomeContinentUnmarshaller.class);

    public static AnimalsAndProperties unmarshal(File file) {
        AnimalsAndProperties animalsAndProperties = null;

        try {
            JAXBContext context = JAXBContext.newInstance(AnimalsAndProperties.class);
            animalsAndProperties = (AnimalsAndProperties) context.createUnmarshaller().unmarshal(new FileReader(file));

            printAnimalInfo(animalsAndProperties);
        }
        catch (JAXBException | FileNotFoundException e) {
            LOGGER.info(e);
        }

        return animalsAndProperties;
    }

    public static void printAnimalInfo(AnimalsAndProperties animals) {
        PetUnmarshaller.printPetInfo(animals.getPet());
        DogUnmarshaller.printDogInfo(animals.getDog());
        WildAnimalUnmarshaller.printWildAnimalInfo(animals.getWildAnimal());
        HomeContinentUnmarshaller.printHomeContinentInfo(animals.getHomeContinent());
        DomesticOrWildUnmarshaller.printDomesticOrWildInfo(animals.getDomesticOrWild());
    }
}
