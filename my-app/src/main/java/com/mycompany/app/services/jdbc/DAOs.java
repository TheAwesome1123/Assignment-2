package com.mycompany.app.services.jdbc;

import com.mycompany.app.dao.jdbc.*;

public class DAOs {
    private static final AnimalDAO animalDAO = new AnimalDAO();
    private static final PetDAO petDAO = new PetDAO();
    private static final WildAnimalDAO wildAnimalDAO = new WildAnimalDAO();
    private static final DomesticOrWildAnimalDAO DOMESTIC_OR_WILD_ANIMAL_DAO = new DomesticOrWildAnimalDAO();
    private static final CatDAO catDAO = new CatDAO();
    private static final DogDAO dogDAO = new DogDAO();
    private static final OwnerDAO ownerDAO = new OwnerDAO();
    private static final HomeContinentDAO homeContinentDAO = new HomeContinentDAO();
    private static final WildAnimalColorDAO wildAnimalColorDAO = new WildAnimalColorDAO();
    private static final WildAnimalsAndColorsDAO wildAnimalsAndColorsDAO = new WildAnimalsAndColorsDAO();
    private static final DomesticAnimalDAO domesticAnimalDAO = new DomesticAnimalDAO();
    private static final DomesticOrWildColorDAO domesticOrWildColorDAO = new DomesticOrWildColorDAO();
    private static final DomesticOrWildAnimalsAndColorsDAO domesticOrWildAnimalsAndColorsDAO =
            new DomesticOrWildAnimalsAndColorsDAO();

    public static AnimalDAO getAnimalDAO() {
        return animalDAO;
    }

    public static PetDAO getPetDAO() {
        return petDAO;
    }

    public static WildAnimalDAO getWildAnimalDAO() {
        return wildAnimalDAO;
    }

    public static DomesticOrWildAnimalDAO getDomesticOrWildDAO() {
        return DOMESTIC_OR_WILD_ANIMAL_DAO;
    }

    public static CatDAO getCatDAO() {
        return catDAO;
    }

    public static DogDAO getDogDAO() {
        return dogDAO;
    }

    public static OwnerDAO getOwnerDAO() {
        return ownerDAO;
    }

    public static HomeContinentDAO getHomeContinentDAO() {
        return homeContinentDAO;
    }

    public static WildAnimalColorDAO getWildAnimalColorDAO() {
        return wildAnimalColorDAO;
    }

    public static WildAnimalsAndColorsDAO getWildAnimalsAndColorsDAO() {
        return wildAnimalsAndColorsDAO;
    }

    public static DomesticAnimalDAO getDomesticAnimalDAO() {
        return domesticAnimalDAO;
    }

    public static DomesticOrWildColorDAO getDomesticOrWildColorDAO() {
        return domesticOrWildColorDAO;
    }

    public static DomesticOrWildAnimalsAndColorsDAO getDomesticOrWildAnimalsAndColorsDAO() {
        return domesticOrWildAnimalsAndColorsDAO;
    }
}
