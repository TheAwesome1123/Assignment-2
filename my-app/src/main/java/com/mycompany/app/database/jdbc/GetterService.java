package com.mycompany.app.database.jdbc;

import com.mycompany.app.models.*;

public class GetterService {
    public Animal getAnimal(int id) {
        return DAOs.getAnimalDAO().getAnimal(id);
    }

    public Pet getPet(int id) {
        return DAOs.getPetDAO().getPet(id);
    }

    public WildAnimal getWildAnimal(int id) {
        return DAOs.getWildAnimalDAO().getWildAnimal(id);
    }

    public DomesticOrWild getDomesticOrWild(int id) {
        return DAOs.getDomesticOrWildDAO().getDomesticOrWildAnimal(id);
    }

    public Dog getDog(int id) {
        return DAOs.getDogDAO().getDog(id);
    }

    public Cat getCat(int id) {
        return DAOs.getCatDAO().getCat(id);
    }

    public Owner getOwner(int id) {
        return DAOs.getOwnerDAO().getOwner(id);
    }

    public HomeContinent getHomeContinent(int id) {
        return DAOs.getHomeContinentDAO().getHomeContinent(id);
    }

    public WildAnimalColor getWildAnimalColor(int id) {
        return DAOs.getWildAnimalColorDAO().getWildAnimalColor(id);
    }

    public WildAnimalAndColorRelation getWildAnimalAndColorRelation(int id) {
        return DAOs.getWildAnimalsAndColorsDAO().getWildAnimalAndColorRelation(id);
    }

    public DomesticAnimal getDomesticAnimal(int id) {
        return DAOs.getDomesticAnimalDAO().getDomesticAnimal(id);
    }

    public DomesticOrWildColor getDomesticOrWildColor(int id) {
        return DAOs.getDomesticOrWildColorDAO().getDomesticOrWildColor(id);
    }

    public DomesticOrWildAnimalAndColorRelation getDomesticOrWildAnimalAndColorRelation(int id) {
        return DAOs.getDomesticOrWildAnimalsAndColorsDAO().getDomesticOrWildAnimalAndColorRelation(id);
    }
}
