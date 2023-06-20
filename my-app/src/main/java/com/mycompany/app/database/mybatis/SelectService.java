package com.mycompany.app.database.mybatis;

import com.mycompany.app.dao.mybatis.AnimalDAO;
import com.mycompany.app.dao.mybatis.OwnerDAO;
import com.mycompany.app.dao.mybatis.PetDAO;
import com.mycompany.app.models.Animal;
import com.mycompany.app.models.Owner;
import com.mycompany.app.models.Pet;

public class SelectService {


    public static Animal getAnimal(int id) {
        return new AnimalDAO().getAnimal(id);
    }

    public static Pet getPet(int id) {
        return new PetDAO().getPet(id);
    }

    public static Owner getOwner(int id) {
        return new OwnerDAO().getOwner(id);
    }
}
