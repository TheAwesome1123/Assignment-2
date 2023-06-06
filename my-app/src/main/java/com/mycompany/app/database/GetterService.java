package com.mycompany.app.database;

import com.mycompany.app.dao.*;
import com.mycompany.app.models.*;

import java.sql.SQLException;

public class GetterService {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public Animal getAnimal(int id) {
        return new AnimalDAO().getAnimal(id);
    }

    public Pet getPet(int id) {
        return new PetDAO().getPet(id);
    }

    public WildAnimal getWildAnimal(int id) {
        return new WildAnimalDAO().getWildAnimal(id);
    }

    public DomesticOrWild getDomesticOrWild(int id) {
        return new DomesticOrWildDAO().getDomesticOrWildAnimal(id);
    }

    public Dog getDog(int id) {
        return new DogDAO().getDog(id);
    }

    public Cat getCat(int id) {
        return new CatDAO().getCat(id);

    }

    public Owner getOwner(int id) {
        return new OwnerDAO().getOwner(id);
    }

    public HomeContinent getHomeContinent(int id) {
        return new HomeContinentDAO().getHomeContinent(id);
    }

    public WildAnimalColor getWildAnimalColor(int id) {
        return new WildAnimalColorDAO().getWildAnimalColor(id);

    }

    public WildAnimalAndColorRelation getWildAnimalAndColorRelation(int id) {
        return new WildAnimalsAndColorsDAO().getWildAnimalAndColorRelation(id);
    }

    public DomesticAnimal getDomesticAnimal(int id) {
        return new DomesticAnimalDAO().getDomesticAnimal(id);
    }

    public DomesticOrWildColor getDomesticOrWildColor(int id) {
        return new DomesticOrWildColorDAO().getDomesticOrWildColor(id);

    }

    public DomesticOrWildAnimalAndColorRelation getDomesticOrWildAnimalAndColorRelation(int id) {
        return new DomesticOrWildAnimalsAndColorsDAO().getDomesticOrWildAnimalAndColorRelation(id);
    }
}
