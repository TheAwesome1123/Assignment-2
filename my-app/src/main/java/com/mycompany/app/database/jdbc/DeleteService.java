package com.mycompany.app.database.jdbc;

import com.mycompany.app.dao.jdbc.*;
import com.mycompany.app.models.*;

public class DeleteService {
    public static final AnimalDAO animalDAO = DAOs.getAnimalDAO();
    public static final PetDAO petDAO = DAOs.getPetDAO();
    public static final CatDAO catDAO = DAOs.getCatDAO();
    public static final DogDAO dogDAO = DAOs.getDogDAO();
    public static final OwnerDAO ownerDAO = DAOs.getOwnerDAO();
    public static final HomeContinentDAO homeContinentDAO = DAOs.getHomeContinentDAO();
    public static final WildAnimalDAO wildAnimalDAO = DAOs.getWildAnimalDAO();
    public static final WildAnimalColorDAO wildAnimalColorDAO = DAOs.getWildAnimalColorDAO();
    public static final WildAnimalsAndColorsDAO wildAnimalsAndColorsDAO = DAOs.getWildAnimalsAndColorsDAO();
    public static final DomesticOrWildAnimalDAO DOMESTIC_OR_WILD_ANIMAL_DAO = DAOs.getDomesticOrWildDAO();
    public static final DomesticAnimalDAO domesticAnimalDAO = DAOs.getDomesticAnimalDAO();
    public static final DomesticOrWildColorDAO domesticOrWildColorDAO = DAOs.getDomesticOrWildColorDAO();
    public static final DomesticOrWildAnimalsAndColorsDAO domesticOrWildAnimalsAndColorsDAO =
        DAOs.getDomesticOrWildAnimalsAndColorsDAO();

    public static void deleteAnimal(int animalID) {
        animalDAO.deleteAnimal(animalID);
    }

    public static void deletePet(int petID) {
        Pet pet = petDAO.getPet(petID);
        int animalID = pet.getAnimalID();

        petDAO.deletePet(petID);
        deleteAnimal(animalID);
    }

    public static void deleteWildAnimal(int wildAnimalID) {
        WildAnimal wildAnimal = wildAnimalDAO.getWildAnimal(wildAnimalID);
        int animalID = wildAnimal.getAnimalID();

        wildAnimalDAO.deleteWildAnimal(wildAnimalID);
        deleteAnimal(animalID);
    }

    public static void deleteDomesticOrWildAnimal(int domesticOrWildID) {
        DomesticOrWildAnimal domesticOrWildAnimal = DOMESTIC_OR_WILD_ANIMAL_DAO.getDomesticOrWildAnimal(domesticOrWildID);
        int animalID = domesticOrWildAnimal.getAnimalID();

        DOMESTIC_OR_WILD_ANIMAL_DAO.deleteDomesticOrWildAnimal(domesticOrWildID);
        deleteAnimal(animalID);
    }

    public static void deleteDomesticAnimal(int domesticAnimalID) {
        DomesticAnimal domesticAnimal = domesticAnimalDAO.getDomesticAnimal(domesticAnimalID);
        int domesticOrWildID = domesticAnimal.getDomesticOrWildID();

        deleteDomesticOrWildAnimal(domesticOrWildID);
        domesticAnimalDAO.deleteDomesticOrWildAnimal(domesticAnimalID);
    }

    public static void deleteDog(int dogID) {
        Dog dog = dogDAO.getDog(dogID);
        int petID = dog.getPetID();

        dogDAO.deleteDog(dogID);
        deletePet(petID);
    }

    public static void deleteCat(int catID) {
        Cat cat = catDAO.getCat(catID);
        int petID = cat.getPetID();

        catDAO.deleteCat(catID);
        deletePet(petID);
    }

    public static void deleteOwner(int ownerID) {
        ownerDAO.deleteOwner(ownerID);
    }

    public static void deleteHomeContinent(int homeContinentID) {
        homeContinentDAO.deleteHomeContinent(homeContinentID);
    }

    public static void deleteWildAnimalColor(int wildAnimalColorID) {
       wildAnimalColorDAO.deleteWildAnimalColor(wildAnimalColorID);
    }

    public static void deleteDomesticOrWildAnimalColor(int domesticOrWildAnimalColorID) {
       domesticOrWildColorDAO.deleteDomesticOrWildColor(domesticOrWildAnimalColorID);
    }

    public static void deleteWildAnimalAndColorRelation(int relationID, int wildAnimalID, int colorID) {
        wildAnimalsAndColorsDAO.deleteWildAnimalAndColorRelation(relationID, wildAnimalID, colorID);
    }

    public static void deleteDomesticOrWildAnimalAndColorRelation(int relationID, int domesticOrWildID, int colorID) {
        domesticOrWildAnimalsAndColorsDAO.deleteDomesticOrWildAnimalAndColorRelation(relationID, domesticOrWildID, colorID);
    }
}
