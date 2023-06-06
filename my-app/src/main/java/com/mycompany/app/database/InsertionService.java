package com.mycompany.app.database;

import com.mycompany.app.dao.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionService {
    private static final Logger LOGGER = LogManager.getLogger(InsertionService.class);
    public static int animalID = DatabaseMain.getAnimalID();
    public static int petID = DatabaseMain.getPetID();
    public static int ownerID = DatabaseMain.getOwnerID();
    public static int wildAnimalID = DatabaseMain.getWildAnimalID();
    public static int domesticOrWildID = DatabaseMain.getDomesticOrWildID();
    public static int wildAnimalColorID = DatabaseMain.getWildAnimalColorID();
    public static int domesticOrWildColorID = DatabaseMain.getDomesticOrWildColorID();

    public static void addPet(String sex, String type, String breed, String name) {
        new AnimalDAO().createAnimal("Pet", sex);
        new PetDAO().createPet(type, name, ownerID, animalID);

        if(type.equals("Dog")) {
            new DogDAO().createDog(breed, petID);
        }
        else {
            new CatDAO().createCat(breed, petID);
        }

        animalID++;
        petID++;
        ownerID++;
    }

    public static void addOwner(String firstName, String lastName) {
        new OwnerDAO().createOwner(firstName, lastName);
    }

    public static void addWildAnimal(String type, String sex) {
        new AnimalDAO().createAnimal("Wild", sex);
        new WildAnimalDAO().createWildAnimal(type, animalID);

        animalID++;
    }

    public static void addDomesticOrWildAnimal(String type, String sex, boolean isDomesticated, String name) {
        new AnimalDAO().createAnimal("DomesticOrWild", sex);
        new DomesticOrWildDAO().createDomesticOrWildAnimal(type, isDomesticated, name, ownerID,
                animalID);

        if(isDomesticated) {
            new DomesticAnimalDAO().createDomesticAnimal(name, ownerID, domesticOrWildID);
        }

        animalID++;
        ownerID++;
    }

    public static void addHomeContinent(String continent) {
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
