package com.mycompany.app.database;

import com.mycompany.app.dao.*;
import com.mycompany.app.models.DomesticOrWildColor;
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

            InsertionMethods.addOwner("Bob", "Smith");
            InsertionMethods.addPet("Male", "Dog", "German Shepherd", "Max");

            InsertionMethods.addOwner("Sarah", "Jones");
            InsertionMethods.addPet("Female", "Cat", "American Bobtail", "Emma");

            InsertionMethods.addWildAnimal("Wolf", "Female");
            InsertionMethods.addHomeContinent("North America");
            InsertionMethods.addWildAnimalColor("Gray", "Light");
            InsertionMethods.addWildAnimalAndColorRelation(wildAnimalID, wildAnimalColorID);
            wildAnimalColorID++;
            InsertionMethods.addWildAnimalColor("Gray", "Dark");
            InsertionMethods.addWildAnimalAndColorRelation(wildAnimalID, wildAnimalColorID);
            wildAnimalColorID++;
            wildAnimalID++;

            InsertionMethods.addOwner("Robert", "Thompson");
            InsertionMethods.addDomesticOrWildAnimal("Horse", "Male", true, "Jack");
            InsertionMethods.addDomesticOrWildColor("White", "Normal");
            InsertionMethods.addDomesticOrWildAnimalAndColorRelation(domesticOrWildID, domesticOrWildColorID);
            domesticOrWildColorID++;
            InsertionMethods.addDomesticOrWildColor("Brown", "Normal");
            InsertionMethods.addDomesticOrWildAnimalAndColorRelation(domesticOrWildID, domesticOrWildColorID);
            domesticOrWildColorID++;
            domesticOrWildID++;

        }
        catch(SQLException se) {
            LOGGER.info(se.getMessage());
        }
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
