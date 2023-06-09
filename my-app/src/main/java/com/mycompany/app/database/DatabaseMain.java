package com.mycompany.app.database;

import com.mycompany.app.dao.OwnerDAO;
import com.mycompany.app.dao.PetDAO;
import com.mycompany.app.dao.WildAnimalDAO;
import com.mycompany.app.models.Animal;
import com.mycompany.app.models.WildAnimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseMain {
    private static final Logger LOGGER = LogManager.getLogger(DatabaseMain.class);
    private static int animalID = 1;
    private static int petID = 1;
    private static int dogID = 1;
    private static int catID = 1;
    private static int ownerID = 1;
    private static int wildAnimalID = 1;
    private static int domesticOrWildID = 1;
    private static int wildAnimalColorID = 1;
    private static int domesticOrWildColorID = 1;
    public static void main(String[] args) {
        insertion();
        updateTables();
        updateEntries();
        DeleteService.deleteDog(1);
        //getStuff();
    }

    public static void insertion() {
        InsertionService.addOwner("Bob", "Smith");
        InsertionService.addPet("Male", "Dog", "German Shepherd", "Max", ownerID, animalID, petID);
        animalID++;
        petID++;
        ownerID++;
        dogID++;

        InsertionService.addOwner("Sarah", "Jones");
        InsertionService.addPet("Female", "Cat", "American Bobtail", "Emma", ownerID, animalID, petID);
        animalID++;
        petID++;
        ownerID++;
        catID++;

        InsertionService.addWildAnimal("Wolf", "Female", animalID);
        InsertionService.addHomeContinent("North America", wildAnimalID);

        InsertionService.addWildAnimalColor("Gray", "Light");
        InsertionService.addWildAnimalAndColorRelation(wildAnimalID, wildAnimalColorID);
        wildAnimalColorID++;
        InsertionService.addWildAnimalColor("Gray", "Dark");
        InsertionService.addWildAnimalAndColorRelation(wildAnimalID, wildAnimalColorID);
        wildAnimalColorID++;

        animalID++;
        wildAnimalID++;

        InsertionService.addOwner("Robert", "Thompson");
        InsertionService.addDomesticOrWildAnimal("Horse", "Male", true, "Jack",
            ownerID, animalID, domesticOrWildID);

        InsertionService.addDomesticOrWildColor("White", "Normal");
        InsertionService.addDomesticOrWildAnimalAndColorRelation(domesticOrWildID, domesticOrWildColorID);
        domesticOrWildColorID++;
        InsertionService.addDomesticOrWildColor("Brown", "Normal");
        InsertionService.addDomesticOrWildAnimalAndColorRelation(domesticOrWildID, domesticOrWildColorID);
        domesticOrWildColorID++;

        animalID++;
        ownerID++;
        domesticOrWildID++;
    }

    public static void updateTables() {
        TableAlterer.updatePetTable();
        TableAlterer.updateOwnerTable();
        TableAlterer.updateWildAnimalTable();
    }

    private static void updateEntries() {
        PetDAO petDAO = new PetDAO();
        OwnerDAO ownerDAO = new OwnerDAO();
        WildAnimalDAO wildAnimalDAO = new WildAnimalDAO();

        double ownerHeight = 5.0;

        for(int i = 1; i < petID; i++) {
            petDAO.updatePetAge(i, 5);
        }

        for(int i = 1; i < ownerID; i++) {
            ownerDAO.updateOwnerHeight(i, ownerHeight);
            ownerHeight += 0.5;
        }

        for(int i = 1; i < wildAnimalID; i++) {
            wildAnimalDAO.updateWildAnimalWeight(i, 100);
        }
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
}
