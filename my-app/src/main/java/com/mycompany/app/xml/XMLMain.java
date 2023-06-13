package com.mycompany.app.xml;

import java.io.File;
import java.io.FileNotFoundException;

import com.mycompany.app.xml.animalsandproperties.AnimalsAndPropertiesUnmarshaller;
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

    private static File petFile, dogFile, homeContinentFile, domesticOrWildFile, wildAnimalFile, petSchema, dogSchema,
        homeContinentSchema, domesticOrWildSchema, wildAnimalSchema, animalsAndPropertiesFile,
        animalsAndPropertiesSchema;

    public static void main(String[] args ) {
        try {
            // Find files.
            petFile = new File("my-app/src/main/java/com/mycompany/app/xml/pet/Pet.xml");
            petSchema = new File("my-app/src/main/java/com/mycompany/app/xml/pet/Pet.xsd");

            dogFile = new File("my-app/src/main/java/com/mycompany/app/xml/dog/Dog.xml");
            dogSchema = new File("my-app/src/main/java/com/mycompany/app/xml/dog/Dog.xsd");

            homeContinentFile = new File(
            "my-app/src/main/java/com/mycompany/app/xml/homecontinent/HomeContinent.xml");
            homeContinentSchema = new File(
            "my-app/src/main/java/com/mycompany/app/xml/homecontinent/HomeContinent.xsd");

            domesticOrWildFile = new File(
            "my-app/src/main/java/com/mycompany/app/xml/domesticorwild/DomesticOrWild.xml");
            domesticOrWildSchema = new File(
            "my-app/src/main/java/com/mycompany/app/xml/domesticorwild/DomesticOrWild.xsd");

            wildAnimalFile = new File("my-app/src/main/java/com/mycompany/app/xml/wildanimal/WildAnimal.xml");
            wildAnimalSchema = new File("my-app/src/main/java/com/mycompany/app/xml/wildanimal/WildAnimal.xsd");

            animalsAndPropertiesFile = new File(
            "my-app/src/main/java/com/mycompany/app/xml/animalsandproperties/AnimalsAndProperties.xml");
            animalsAndPropertiesSchema = new File(
            "my-app/src/main/java/com/mycompany/app/xml/animalsandproperties/AnimalsAndProperties.xsd");

            XMLValidator.validate(wildAnimalSchema, wildAnimalFile);
            XMLParser.doParsing(wildAnimalFile);

//            PetUnmarshaller.unmarshal(petFile);
//            DogUnmarshaller.unmarshal(dogFile);
//            HomeContinentUnmarshaller.unmarshal(homeContinentFile);
//            DomesticOrWildUnmarshaller.unmarshal(domesticOrWildFile);
//            WildAnimalUnmarshaller.unmarshal(wildAnimalFile);
//            AnimalsAndPropertiesUnmarshaller.unmarshal(animalsAndPropertiesFile);
        }
        catch(NullPointerException npe) {
            LOGGER.info(npe.getMessage());
        }
    }

    public static DocumentBuilderFactory getDocumentBuilderFactory() {
        return documentBuilderFactory;
    }
}