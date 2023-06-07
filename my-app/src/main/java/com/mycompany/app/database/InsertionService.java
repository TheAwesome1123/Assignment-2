package com.mycompany.app.database;

import com.mycompany.app.dao.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionService {
    private static final Logger LOGGER = LogManager.getLogger(InsertionService.class);

    public static void addPet(String sex, String type, String breed, String name, int ownerID, int animalID, int petID) {
        new AnimalDAO().createAnimal("Pet", sex);
        new PetDAO().createPet(type, name, ownerID, animalID);

        if(type.equals("Dog")) {
            new DogDAO().createDog(breed, petID);
        }
        else {
            new CatDAO().createCat(breed, petID);
        }
    }

    public static void addOwner(String firstName, String lastName) {
        new OwnerDAO().createOwner(firstName, lastName);
    }

    public static void addWildAnimal(String type, String sex, int animalID) {
        new AnimalDAO().createAnimal("Wild", sex);
        new WildAnimalDAO().createWildAnimal(type, animalID);
    }

    public static void addDomesticOrWildAnimal(String type, String sex, boolean isDomesticated, String name,
        int ownerID, int animalID, int domesticOrWildID) {
            new AnimalDAO().createAnimal("DomesticOrWild", sex);
            new DomesticOrWildDAO().createDomesticOrWildAnimal(type, isDomesticated, name, ownerID,
                    animalID);

            if(isDomesticated) {
                new DomesticAnimalDAO().createDomesticAnimal(name, ownerID, domesticOrWildID);
            }
    }

    public static void addHomeContinent(String continent, int wildAnimalID) {
        new HomeContinentDAO().createHomeContinent(continent, wildAnimalID);
    }

    public static void addWildAnimalColor(String color, String shade) {
        new WildAnimalColorDAO().createWildAnimalColor(color, shade);
    }

    public static void addDomesticOrWildColor(String color, String shade) {
        new DomesticOrWildColorDAO().createDomesticOrWildColor(color, shade);
    }

    public static void addWildAnimalAndColorRelation(int wildAnimalID, int wildAnimalColorID) {
        new WildAnimalsAndColorsDAO().createWildAnimalAndColorRelation(wildAnimalID, wildAnimalColorID);
    }

    public static void addDomesticOrWildAnimalAndColorRelation(int domesticOrWildID, int domesticOrWildColorID) {
        new DomesticOrWildAnimalsAndColorsDAO().createDomesticOrWildAnimalAndColorRelation(domesticOrWildID,
            domesticOrWildColorID);
    }
}
