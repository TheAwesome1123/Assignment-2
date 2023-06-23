package com.mycompany.app.database.mybatis;

import com.mycompany.app.dao.mybatis.*;
import com.mycompany.app.models.*;

public class UpdateService {
    public static void updateAnimal(Animal animal) {
        new AnimalDAO().updateAnimal(animal);
    }
    public static void updatePet(Pet pet) {
        new PetDAO().updatePet(pet);
    }

    public static void updateDog(Dog dog) {
        new DogDAO().updateDog(dog);
    }

    public static void updateCat(Cat cat) {
        new CatDAO().updateCat(cat);
    }

    public static void updateOwner(Owner owner) {
        new OwnerDAO().updateOwner(owner);
    }

    public static void updateWildAnimal(WildAnimal wildAnimal) {
        new WildAnimalDAO().updateWildAnimal(wildAnimal);
    }

    public static void updateHomeContinent(HomeContinent homeContinent) {
        new HomeContinentDAO().updateHomeContinent(homeContinent);
    }

    public static void updateWildAnimalColor(WildAnimalColor wildAnimalColor) {
        new WildAnimalColorDAO().updateWildAnimalColor(wildAnimalColor);
    }

    public static void updateWildAnimalAndColorRelation(WildAnimalAndColorRelation wildAnimalAndColorRelation) {
        new WildAnimalsAndColorsDAO().updateWildAnimalAndColorRelation(wildAnimalAndColorRelation);
    }

    public static void updateDomesticOrWildAnimal(DomesticOrWildAnimal domesticOrWildAnimal) {
        new DomesticOrWildAnimalDAO().updateDomesticOrWildAnimal(domesticOrWildAnimal);
    }

    public static void updateDomesticAnimal(DomesticAnimal domesticAnimal) {
        new DomesticAnimalDAO().updateDomesticAnimal(domesticAnimal);
    }

    public static void updateDomesticOrWildAnimalColor(DomesticOrWildAnimalColor domesticOrWildAnimalColor) {
        new DomesticOrWildAnimalColorDAO().updateDomesticOrWildAnimalColor(domesticOrWildAnimalColor);
    }

    public static void updateDomesticOrWildAnimalAndColorRelation(DomesticOrWildAnimalAndColorRelation relation) {
        new DomesticOrWildAnimalsAndColorsDAO().updateDomesticOrWildAnimalAndColorRelation(relation);
    }
}
