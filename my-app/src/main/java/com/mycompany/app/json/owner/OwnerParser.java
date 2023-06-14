package com.mycompany.app.json.owner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.app.json.JSONMain;
import com.mycompany.app.models.Owner;
import com.mycompany.app.models.WildAnimalColor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OwnerParser {
    private static final Logger LOGGER = LogManager.getLogger(OwnerParser.class);

    public static void parse() {
        try {
            byte[] data = Files.readAllBytes(Paths.get(JSONMain.getOwnerFile()));
            ObjectMapper objectMapper = new ObjectMapper();

            Owner owner = objectMapper.readValue(data, Owner.class);
            printInfo(owner);
        }
        catch(IOException ioe) {
            LOGGER.info(ioe.getMessage());
        }
    }

    public static void printInfo(Owner owner) {
        LOGGER.info("Owner");
        LOGGER.info("ID: " + owner.getOwnerID());
        LOGGER.info("First Name: " + owner.getFirstName());
        LOGGER.info("Last Name: " + owner.getLastName());
        LOGGER.info("Height: " + owner.getHeight());
        LOGGER.info("Cities visited: " + owner.getCitiesVisited() + "\n");
    }
}
