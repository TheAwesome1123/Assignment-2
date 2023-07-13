package com.mycompany.app.services.jdbc;

import com.mycompany.app.dao.jdbc.AnimalDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionService {
    private static final AnimalDAO animalDAO = DAOs.getAnimalDAO();
    private static final Logger LOGGER = LogManager.getLogger(InsertionService.class);

    public static void addPet(String sex, String type, String breed, String name, int ownerID, int animalID, int petID) {
        animalDAO.createAnimal("Pet", sex);
        DAOs.getPetDAO().createPet(type, name, ownerID, animalID);

        if(type.equals("Dog")) {
            DAOs.getDogDAO().createDog(breed, petID);
        }
        else {
            DAOs.getCatDAO().createCat(breed, petID);
        }
    }

    public static void addOwner(String firstName, String lastName) {
        DAOs.getOwnerDAO().createOwner(firstName, lastName);
    }

    public static void addWildAnimal(String type, String sex, int animalID) {
        animalDAO.createAnimal("Wild", sex);
        DAOs.getWildAnimalDAO().createWildAnimal(type, animalID);
    }

    public static void addDomesticOrWildAnimal(String type, String sex, boolean isDomesticated, String name,
        int ownerID, int animalID, int domesticOrWildID) {
            animalDAO.createAnimal("DomesticOrWild", sex);
            DAOs.getDomesticOrWildDAO().createDomesticOrWildAnimal(type, isDomesticated, name, ownerID,
                    animalID);

            if(isDomesticated) {
                DAOs.getDomesticAnimalDAO().createDomesticAnimal(name, ownerID, domesticOrWildID);
            }
    }

    public static void addHomeContinent(String continent, int wildAnimalID) {
       DAOs.getHomeContinentDAO().createHomeContinent(continent, wildAnimalID);
    }

    public static void addWildAnimalColor(String color, String shade) {
       DAOs.getWildAnimalColorDAO().createWildAnimalColor(color, shade);
    }

    public static void addDomesticOrWildColor(String color, String shade) {
       DAOs.getDomesticOrWildColorDAO().createDomesticOrWildColor(color, shade);
    }

    public static void addWildAnimalAndColorRelation(int wildAnimalID, int wildAnimalColorID) {
        DAOs.getWildAnimalsAndColorsDAO().createWildAnimalAndColorRelation(wildAnimalID, wildAnimalColorID);
    }

    public static void addDomesticOrWildAnimalAndColorRelation(int domesticOrWildID, int domesticOrWildColorID) {
        DAOs.getDomesticOrWildAnimalsAndColorsDAO().createDomesticOrWildAnimalAndColorRelation(domesticOrWildID,
            domesticOrWildColorID);
    }
}
