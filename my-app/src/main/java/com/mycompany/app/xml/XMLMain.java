package com.mycompany.app.xml;

import java.io.File;

import com.mycompany.app.models.Dog;
import com.mycompany.app.models.Pet;
import com.mycompany.app.xml.dog.DogUnmarshaller;
import com.mycompany.app.xml.domesticorwild.DomesticOrWildUnmarshaller;
import com.mycompany.app.xml.homecontinent.HomeContinentUnmarshaller;
import com.mycompany.app.xml.pet.PetUnmarshaller;
import com.mycompany.app.xml.wildanimal.WildAnimalUnmarshaller;
import org.apache.logging.log4j.*;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLMain {
    private static final Logger LOGGER = LogManager.getLogger(XMLMain.class);
    private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    private static File petFile, dogFile, homeContinentFile, domesticOrWildFile, wildAnimalFile, schema;

    public static void main(String[] args ){
        try {
            // Find files.
            petFile = new File("my-app/src/main/java/com/mycompany/app/xml/pet/Pet.xml");
            schema = new File("my-app/src/main/java/com/mycompany/app/xml/pet/Pet.xsd");
            dogFile = new File("my-app/src/main/java/com/mycompany/app/xml/dog/Dog.xml");
            homeContinentFile = new File(
                "my-app/src/main/java/com/mycompany/app/xml/homecontinent/HomeContinent.xml");
            domesticOrWildFile = new File(
                "my-app/src/main/java/com/mycompany/app/xml/domesticorwild/DomesticOrWild.xml");
            wildAnimalFile = new File("my-app/src/main/java/com/mycompany/app/xml/wildanimal/WildAnimal.xml");


            LOGGER.info("Found file " + petFile.getName());
            LOGGER.info("Found file " + schema.getName());

            XMLParser.doParsing(true);
            //XMLValidator.validate();
            PetUnmarshaller.unmarshal(petFile);
            DogUnmarshaller.unmarshal(dogFile);
            HomeContinentUnmarshaller.unmarshal(homeContinentFile);
            DomesticOrWildUnmarshaller.unmarshal(domesticOrWildFile);
            WildAnimalUnmarshaller.unmarshal(wildAnimalFile);
        }
        catch(NullPointerException npe) {
            LOGGER.info("File not found; quitting.");
        }
    }

    public static DocumentBuilderFactory getDocumentBuilderFactory() {
        return documentBuilderFactory;
    }

    public static File getPetFile() {
        return petFile;
    }

    public static File getSchema() {
        return schema;
    }

}
