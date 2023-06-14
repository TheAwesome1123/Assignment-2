package com.mycompany.app.json.wildanimalsandcolors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.app.json.JSONMain;
import com.mycompany.app.json.owner.OwnerParser;
import com.mycompany.app.models.Owner;
import com.mycompany.app.models.WildAnimalAndColorRelation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WildAnimalsAndColorsParser {
    private static final Logger LOGGER = LogManager.getLogger(WildAnimalsAndColorsParser.class);

    public static void parse() {
        try {
            byte[] data = Files.readAllBytes(Paths.get(JSONMain.getWildAnimalsAndColorsFile()));
            ObjectMapper objectMapper = new ObjectMapper();

            WildAnimalAndColorRelation[] wildAnimalAndColorRelations =
                objectMapper.readValue(data, WildAnimalAndColorRelation[].class);
            printInfo(wildAnimalAndColorRelations);
        }
        catch(IOException ioe) {
            LOGGER.info(ioe.getMessage());
        }
    }

    public static void printInfo(WildAnimalAndColorRelation[] wildAnimalAndColorRelations) {
        LOGGER.info("Wild Animal and Color Relations");

        for (WildAnimalAndColorRelation relation: wildAnimalAndColorRelations) {
            LOGGER.info("ID: " + relation.getRelationID());
            LOGGER.info("Wild Animal ID: " + relation.getWildAnimalID());
            LOGGER.info("Color ID: " + relation.getColorID() + "\n");
        }
    }
}
