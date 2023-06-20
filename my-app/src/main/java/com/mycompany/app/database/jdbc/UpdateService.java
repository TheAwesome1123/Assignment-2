package com.mycompany.app.database.jdbc;

public class UpdateService {
    public static void updateAnimal(int id, String type, String sex) {
        DAOs.getAnimalDAO().updateAnimal(id, type, sex);
    }

    public static void updatePet(int id, int age) {
        DAOs.getPetDAO().updatePetAge(id, age);
    }

    public static void updateDog(int id, String breed) {
        DAOs.getDogDAO().updateDog(id, breed);
    }

    public static void updateCat(int id, String breed) {
        DAOs.getCatDAO().updateCat(id, breed);
    }

    public static void updateOwner(int id, double height) {
        DAOs.getOwnerDAO().updateOwnerHeight(id, height);
    }

    public static void updateWildAnimal(int id, int weight) {
        DAOs.getWildAnimalDAO().updateWildAnimalWeight(id, weight);
    }

    public static void updateHomeContinent(int id, String continent) {
        DAOs.getHomeContinentDAO().updateHomeContinent(id, continent);
    }

    public static void updateWildAnimalColor(int id, String color, String shade) {
        DAOs.getWildAnimalColorDAO().updateWildAnimalColor(id, color, shade);
    }

    public static void updateWildAnimalAndColorRelation(int id, int wildAnimalID, int colorID) {
        DAOs.getWildAnimalsAndColorsDAO().updateWildAnimalAndColorRelation(id, wildAnimalID, colorID);
    }

    public static void updateDomesticOrWild(int id, String isDomesticated) {
        DAOs.getDomesticOrWildDAO().updateDomesticOrWildAnimal(id, isDomesticated);
    }

    public static void updateDomesticAnimal(int id, String name) {
        DAOs.getDomesticAnimalDAO().updateDomesticOrWildAnimal(id, name);
    }

    public static void updateDomesticOrWildAnimalColor(int id, String color, String shade) {
        DAOs.getDomesticOrWildColorDAO().updateDomesticOrWildColor(id, color, shade);
    }

    public static void updateDomesticOrWildAnimalAndColorRelation(int id, int domesticOrWildID, int colorID) {
        DAOs.getDomesticOrWildAnimalsAndColorsDAO().updateDomesticOrWildAnimalAndColorRelation(id, domesticOrWildID, colorID);
    }
}
