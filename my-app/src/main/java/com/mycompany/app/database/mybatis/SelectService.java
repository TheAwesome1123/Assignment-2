package com.mycompany.app.database.mybatis;

import com.mycompany.app.dao.mybatis.*;
import com.mycompany.app.models.*;

public class SelectService {
    public static Animal getAnimal(int id) {
        return new AnimalDAO().getAnimal(id);
    }

    public static Pet getPet(int id) {
        return new PetDAO().getPet(id);
    }

    public static Dog getDog(int id) {
        return new DogDAO().getDog(id);
    }

    public static Cat getCat(int id) {
        return new CatDAO().getCat(id);
    }

    public static Owner getOwner(int id) {
        return new OwnerDAO().getOwner(id);
    }

    public static WildAnimal getWildAnimal(int id) {
        return new WildAnimalDAO().getWildAnimal(id);
    }

    public static HomeContinent getHomeContinent(int id) {
        return new HomeContinentDAO().getHomeContinent(id);
    }

    public static WildAnimalColor getWildAnimalColor(int id) {
        return new WildAnimalColorDAO().getWildAnimalColor(id);
    }

    public static WildAnimalAndColorRelation getWildAnimalAndColorRelation(int id) {
        return new WildAnimalsAndColorsDAO().getWildAnimalAndColorRelation(id);
    }

    public static DomesticOrWildAnimal getDomesticOrWildAnimal(int id) {
        return new DomesticOrWildAnimalDAO().getDomesticOrWildAnimal(id);
    }

    public static DomesticAnimal getDomesticAnimal(int id) {
        return new DomesticAnimalDAO().getDomesticAnimal(id);
    }

    public static DomesticOrWildAnimalColor getDomesticOrWildAnimalColor(int id) {
        return new DomesticOrWildAnimalColorDAO().getDomesticOrWildAnimalColor(id);
    }

    public static DomesticOrWildAnimalAndColorRelation getDomesticOrWildAnimalAndColorRelation(int id) {
        return new DomesticOrWildAnimalsAndColorsDAO().getDomesticOrWildAnimalAndColorRelation(id);
    }
}
