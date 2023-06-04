package com.mycompany.app.database;

import com.mycompany.app.dao.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class InsertionMethods {
    private static ConnectionPool connectionPool = DatabaseMain.getConnectionPool();
    private static final Logger LOGGER = LogManager.getLogger(InsertionMethods.class);
    public static int animalID = DatabaseMain.getAnimalID();
    public static int petID = DatabaseMain.getPetID();
    public static int ownerID = DatabaseMain.getOwnerID();
    public static int wildAnimalID = DatabaseMain.getWildAnimalID();
    public static int domesticOrWildID = DatabaseMain.getDomesticOrWildID();
    public static int wildAnimalColorID = DatabaseMain.getWildAnimalColorID();
    public static int domesticOrWildColorID = DatabaseMain.getDomesticOrWildColorID();

    public static void addPet(String sex, String type, String breed, String name) {
        try {
            new AnimalDAO().createAnimal(connectionPool, "Pet", sex);
            new PetDAO().createPet(connectionPool, type, name, ownerID, animalID);

            if(type.equals("Dog")) {
                new DogDAO().createDog(connectionPool, breed, petID);
            }
            else {
                new CatDAO().createCat(connectionPool, breed, petID);
            }

            animalID++;
            petID++;
            ownerID++;
        }
        catch(SQLException se) {
            LOGGER.info("Failure.");
        }
    }

    public static void addOwner(String firstName, String lastName) {
        try {
            new OwnerDAO().createOwner(connectionPool, firstName, lastName);
        }
        catch(SQLException se) {
            LOGGER.info(se.getMessage());
        }
    }

    public static void addWildAnimal(String type, String sex) {
        try {
            new AnimalDAO().createAnimal(connectionPool, "Wild", sex);
            new WildAnimalDAO().createWildAnimal(connectionPool, type, animalID);

            animalID++;
        }
        catch(SQLException se) {
            LOGGER.info(se.getMessage());
        }
    }

    public static void addDomesticOrWildAnimal(String type, String sex, boolean isDomesticated, String name) {
        try {
            new AnimalDAO().createAnimal(connectionPool, "DomesticOrWild", sex);
            new DomesticOrWildDAO().createDomesticOrWildAnimal(connectionPool, type, isDomesticated, name, ownerID,
                    animalID);

            if(isDomesticated) {
                new DomesticAnimalDAO().createDomesticAnimal(connectionPool, name, ownerID, domesticOrWildID);
            }

            animalID++;
            ownerID++;
        }
        catch(SQLException se) {
            LOGGER.info(se.getMessage());
        }
    }

    public static void addHomeContinent(String continent) {
        try {
            new HomeContinentDAO().createHomeContinent(connectionPool, continent, wildAnimalID);
        }
        catch(SQLException se) {
            LOGGER.info(se.getMessage());
        }
    }

    public static void addWildAnimalColor(String color, String shade) {
        try {
            new WildAnimalColorDAO().createWildAnimalColor(connectionPool, color, shade);
        }
        catch(SQLException se) {
            LOGGER.info(se.getMessage());
        }
    }

    public static void addDomesticOrWildColor(String color, String shade) {
        try {
            new DomesticOrWildColorDAO().createDomesticOrWildColor(connectionPool, color, shade);
        }
        catch(SQLException se) {
            LOGGER.info(se.getMessage());
        }
    }

    public static void addWildAnimalAndColorRelation(int wildAnimalID, int wildAnimalColorID) {
        try {
            new WildAnimalsAndColorsDAO().createWildAnimalAndColorRelation(connectionPool, wildAnimalID,
                wildAnimalColorID);
        }
        catch(SQLException se) {
            LOGGER.info(se.getMessage());
        }
    }

    public static void addDomesticOrWildAnimalAndColorRelation(int domesticOrWildID, int domesticOrWildColorID) {
        try {
            new DomesticOrWildAnimalsAndColorsDAO().createDomesticOrWildAnimalAndColorRelation(connectionPool,
                domesticOrWildID, domesticOrWildColorID);
        }
        catch(SQLException se) {
            LOGGER.info(se.getMessage());
        }
    }
}
