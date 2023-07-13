package com.mycompany.app.services.mybatis;

import com.mycompany.app.dao.mybatis.*;

public class InsertService {
    public static void insertAnimal(String type, String sex) {
        new AnimalDAO().createAnimal(type, sex);
    }

    public static void insertPet(String type, String name, int ownerID, int animalID) {
        new PetDAO().createPet(type, name, ownerID, animalID);
    }

    public static void insertCat(String breed, int petID) {
        new CatDAO().createCat(breed, petID);
    }

    public static void insertDog(String breed, int petID) {
        new DogDAO().createDog(breed, petID);
    }

    public static void insertOwner(String firstName, String lastName) {
        new OwnerDAO().createOwner(firstName, lastName);
    }

    public static void insertWildAnimal(String type, int animalID) {
        new WildAnimalDAO().createWildAnimal(type, animalID);
    }

    public static void insertHomeContinent(String continent, int wildAnimalID) {
        new HomeContinentDAO().createHomeContinent(continent, wildAnimalID);
    }

    public static void insertWildAnimalColor(String color, String shade) {
        new WildAnimalColorDAO().createWildAnimalColor(color, shade);
    }

    public static void insertWildAnimalAndColorRelation(int colorId, int wildAnimalID) {
        new WildAnimalsAndColorsDAO().createWildAnimalAndColorRelation(wildAnimalID, colorId);
    }

    public static void insertDomesticOrWildAnimal(String type, boolean isDomesticated, int animalID) {
        new DomesticOrWildAnimalDAO().createDomesticOrWildAnimal(type, isDomesticated, animalID);
    }

    public static void insertDomesticAnimal(String name, int ownerID, int domesticOrWildAnimalID) {
        new DomesticAnimalDAO().createDomesticAnimal(name, ownerID, domesticOrWildAnimalID);
    }

    public static void insertDomesticOrWildAnimalColor(String color, String shade) {
        new DomesticOrWildAnimalColorDAO().createDomesticOrWildAnimalColor(color, shade);
    }

    public static void insertDomesticOrWildAnimalAndColorRelation(int colorId, int domesticOrWildAnimalID) {
        new DomesticOrWildAnimalsAndColorsDAO().createDomesticOrWildAnimalAndColorRelation(domesticOrWildAnimalID, colorId);
    }
}
