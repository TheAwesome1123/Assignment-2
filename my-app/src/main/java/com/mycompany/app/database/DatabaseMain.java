package com.mycompany.app.database;

import com.mycompany.app.models.Animal;
import com.mycompany.app.models.WildAnimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class DatabaseMain {
    private static ConnectionPool connectionPool = new ConnectionPool();
    private static final Logger LOGGER = LogManager.getLogger(DatabaseMain.class);
    private static int animalID = 1;
    private static int petID = 1;
    private static int ownerID = 1;
    private static int wildAnimalID = 1;
    private static int domesticOrWildID = 1;
    private static int wildAnimalColorID = 1;
    private static int domesticOrWildColorID = 1;
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/animals";
        String user = "root";
        String password = "Mcsamdw!n1";

        try {
            connectionPool.initialize(5, url, user, password);
            //insertion();
            //getStuff();
        }
        catch(SQLException se) {
            LOGGER.info(se.getMessage());
        }
    }

    public static void insertion() {
        InsertionService.addOwner("Bob", "Smith");
        InsertionService.addPet("Male", "Dog", "German Shepherd", "Max");

        InsertionService.addOwner("Sarah", "Jones");
        InsertionService.addPet("Female", "Cat", "American Bobtail", "Emma");

        InsertionService.addWildAnimal("Wolf", "Female");
        InsertionService.addHomeContinent("North America");
        InsertionService.addWildAnimalColor("Gray", "Light");
        InsertionService.addWildAnimalAndColorRelation(wildAnimalID, wildAnimalColorID);
        wildAnimalColorID++;
        InsertionService.addWildAnimalColor("Gray", "Dark");
        InsertionService.addWildAnimalAndColorRelation(wildAnimalID, wildAnimalColorID);
        wildAnimalColorID++;
        wildAnimalID++;

        InsertionService.addOwner("Robert", "Thompson");
        InsertionService.addDomesticOrWildAnimal("Horse", "Male", true, "Jack");
        InsertionService.addDomesticOrWildColor("White", "Normal");
        InsertionService.addDomesticOrWildAnimalAndColorRelation(domesticOrWildID, domesticOrWildColorID);
        domesticOrWildColorID++;
        InsertionService.addDomesticOrWildColor("Brown", "Normal");
        InsertionService.addDomesticOrWildAnimalAndColorRelation(domesticOrWildID, domesticOrWildColorID);
        domesticOrWildColorID++;
        domesticOrWildID++;
    }

    public static void getStuff() {
        Animal animal = new GetterService().getAnimal(1);
        LOGGER.info(animal.getID());
        LOGGER.info(animal.getType());
        LOGGER.info(animal.getSex());

        WildAnimal wildAnimal = new GetterService().getWildAnimal(1);
        LOGGER.info(wildAnimal.getWildAnimalID());
        LOGGER.info(wildAnimal.getType());
        LOGGER.info(wildAnimal.getAnimalID());
    }

    public static ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    public static int getAnimalID() {
        return animalID;
    }

    public static int getPetID() {
        return petID;
    }

    public static int getOwnerID() {
        return ownerID;
    }

    public static int getWildAnimalID() {
        return wildAnimalID;
    }

    public static int getDomesticOrWildID() {
        return domesticOrWildID;
    }

    public static int getWildAnimalColorID() {
        return wildAnimalColorID;
    }

    public static int getDomesticOrWildColorID() {
        return domesticOrWildColorID;
    }
}
