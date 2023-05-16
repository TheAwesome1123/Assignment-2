package com.mycompany.app.streams;

import com.mycompany.app.abstracts.WildAnimal;
import com.mycompany.app.enums.HomeContinent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AreThereNoWildAnimalsInAntarctica {
    private static final Logger LOGGER = LogManager.getLogger(AreThereNoWildAnimalsInAntarctica.class);

    public static void areThereNoWildAnimalsInAntarctica(List<WildAnimal> list) {
        boolean areThereNoWildAnimalsInAntarctica = list.stream().noneMatch(wildAnimal ->
            wildAnimal.getHomeContinent() == HomeContinent.ANTARCTICA);

        printResultOfWildAnimalsInAntarctica(areThereNoWildAnimalsInAntarctica);
    }

    public static void printResultOfWildAnimalsInAntarctica(boolean result) {
        if(result) {
            LOGGER.info("None of these wild animals are in Antarctica.");
        }
        else {
            LOGGER.info("At least one of these wild animals are in Antarctica.");
        }
    }
}