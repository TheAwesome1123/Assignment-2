package com.mycompany.app.database;

import com.mycompany.app.dao.*;
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
    public static final DomesticOrWildColorDAO domesticOrWildColorDAO = DAOs.getDomesticOrWildColorDAO();

    public static void deleteAnimal(int animalID) {
        DAOs.getAnimalDAO().deleteAnimal(animalID);
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
}
