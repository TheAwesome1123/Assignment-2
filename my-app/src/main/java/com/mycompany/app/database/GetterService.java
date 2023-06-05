package com.mycompany.app.database;

import com.mycompany.app.dao.*;
import com.mycompany.app.models.*;

import java.sql.SQLException;

public class GetterService {
    private ConnectionPool connectionPool = DatabaseMain.getConnectionPool();

    public Animal getAnimal(int id) {
        try {
            return new AnimalDAO().getAnimal(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }

    public Pet getPet(int id) {
        try {
            return new PetDAO().getPet(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }

    public WildAnimal getWildAnimal(int id) {
        try {
            return new WildAnimalDAO().getWildAnimal(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }

    public DomesticOrWild getDomesticOrWild(int id) {
        try {
            return new DomesticOrWildDAO().getDomesticOrWildAnimal(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }

    public Dog getDog(int id) {
        try {
            return new DogDAO().getDog(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }

    public Cat getCat(int id) {
        try {
            return new CatDAO().getCat(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }

    public Owner getOwner(int id) {
        try {
            return new OwnerDAO().getOwner(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }

    public HomeContinent getHomeContinent(int id) {
        try {
            return new HomeContinentDAO().getHomeContinent(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }

    public WildAnimalColor getWildAnimalColor(int id) {
        try {
            return new WildAnimalColorDAO().getWildAnimalColor(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }

    public WildAnimalAndColorRelation getWildAnimalAndColorRelation(int id) {
        try {
            return new WildAnimalsAndColorsDAO().getWildAnimalAndColorRelation(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }

    public DomesticAnimal getDomesticAnimal(int id) {
        try {
            return new DomesticAnimalDAO().getDomesticAnimal(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }

    public DomesticOrWildColor getDomesticOrWildColor(int id) {
        try {
            return new DomesticOrWildColorDAO().getDomesticOrWildColor(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }

    public DomesticOrWildAnimalAndColorRelation getDomesticOrWildAnimalAndColorRelation(int id) {
        try {
            return new DomesticOrWildAnimalsAndColorsDAO().getDomesticOrWildAnimalAndColorRelation(connectionPool, id);
        }
        catch(SQLException se) {
            return null;
        }
    }
}
