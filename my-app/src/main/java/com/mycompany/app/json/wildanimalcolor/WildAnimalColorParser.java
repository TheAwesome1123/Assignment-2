package com.mycompany.app.json.wildanimalcolor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.app.json.JSONMain;
import com.mycompany.app.json.cat.CatParser;
import com.mycompany.app.models.DomesticAnimal;
import com.mycompany.app.models.WildAnimalColor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WildAnimalColorParser {
    private static final Logger LOGGER = LogManager.getLogger(WildAnimalColorParser.class);

    public static void parse() {
        try {
            byte[] data = Files.readAllBytes(Paths.get(JSONMain.getWildAnimalColorFile()));
            ObjectMapper objectMapper = new ObjectMapper();

            WildAnimalColor wildAnimalColor = objectMapper.readValue(data, WildAnimalColor.class);
            printInfo(wildAnimalColor);
        }
        catch(IOException ioe) {
            LOGGER.info(ioe.getMessage());
        }
    }

    public static void printInfo(WildAnimalColor wildAnimalColor) {
        LOGGER.info("Wild Animal Color");
        LOGGER.info("ID: " + wildAnimalColor.getColorID());
        LOGGER.info("Color: " + wildAnimalColor.getColor());
        LOGGER.info("Shade: " + wildAnimalColor.getShade() + "\n");
    }
}
