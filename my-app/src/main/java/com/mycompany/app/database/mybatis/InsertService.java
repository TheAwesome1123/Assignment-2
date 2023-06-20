package com.mycompany.app.database.mybatis;

import com.mycompany.app.dao.mybatis.AnimalDAO;
import com.mycompany.app.dao.mybatis.OwnerDAO;
import com.mycompany.app.dao.mybatis.PetDAO;

public class InsertService {
    public static void insertAnimal(String type, String sex) {
        new AnimalDAO().createAnimal(type, sex);
    }

    public static void insertOwner(String firstName, String lastName) {
        new OwnerDAO().createOwner(firstName, lastName);
    }

    public static void insertPet(String type, String name, int ownerID, int animalID) {
        new PetDAO().createPet(type, name, ownerID, animalID);
    }
}
