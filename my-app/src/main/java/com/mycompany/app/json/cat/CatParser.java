package com.mycompany.app.json.cat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.app.json.JSONMain;
import com.mycompany.app.models.Cat;
import com.mycompany.app.xml.XMLMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CatParser {
    private static final Logger LOGGER = LogManager.getLogger(CatParser.class);

    public static void parse() {
        try {
            byte[] data = Files.readAllBytes(Paths.get(JSONMain.getCatFile()));
            ObjectMapper objectMapper = new ObjectMapper();

            Cat cat = objectMapper.readValue(data, Cat.class);
            printInfo(cat);
        }
        catch(IOException ioe) {
            LOGGER.info(ioe.getMessage());
        }
    }

    public static void printInfo(Cat cat) {
        LOGGER.info("Cat");
        LOGGER.info("ID: " + cat.getCatID());
        LOGGER.info("Breed: " + cat.getBreed());
        LOGGER.info("Pet ID: " + cat.getPetID() + "\n");
    }
}
