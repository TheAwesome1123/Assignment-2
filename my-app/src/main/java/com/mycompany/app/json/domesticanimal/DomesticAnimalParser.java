package com.mycompany.app.json.domesticanimal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.app.json.JSONMain;
import com.mycompany.app.json.cat.CatParser;
import com.mycompany.app.models.Cat;
import com.mycompany.app.models.DomesticAnimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

public class DomesticAnimalParser {
    private static String date;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy");

    private static final Logger LOGGER = LogManager.getLogger(DomesticAnimalParser.class);

    public static void parse() {
        try {
            byte[] data = Files.readAllBytes(Paths.get(JSONMain.getDomesticAnimalFile()));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setDateFormat(simpleDateFormat);

            DomesticAnimal domesticAnimal = objectMapper.readValue(data, DomesticAnimal.class);
            printInfo(domesticAnimal);
        }
        catch(IOException ioe) {
            LOGGER.info(ioe.getMessage());
        }
    }

    public static void printInfo(DomesticAnimal domesticAnimal) {
        LOGGER.info("Domestic Animal");
        LOGGER.info("ID: " + domesticAnimal.getDomesticAnimalID());
        LOGGER.info("Name: " + domesticAnimal.getName());
        LOGGER.info("Owner ID: " + domesticAnimal.getOwnerID());

        String date = simpleDateFormat.format(domesticAnimal.getDateOfBirth());
        LOGGER.info("Date of Birth: " + date);
        LOGGER.info("Domestic/Wild Animal ID: " + domesticAnimal.getDomesticOrWildID() + "\n");
    }
}
