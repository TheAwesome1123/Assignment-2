package com.mycompany.app.database.mybatis;

import com.mycompany.app.dao.mybatis.AnimalDAO;
import com.mycompany.app.dao.mybatis.OwnerDAO;
import com.mycompany.app.dao.mybatis.PetDAO;
import com.mycompany.app.models.Animal;
import com.mycompany.app.models.Owner;
import com.mycompany.app.models.Pet;

public class UpdateService {
    public static void updateAnimal(Animal animal) {
        new AnimalDAO().updateAnimal(animal);
    }
    public static void updatePet(Pet pet) {
        new PetDAO().updatePet(pet);
    }

    public static void updateOwner(Owner owner) {
        new OwnerDAO().updateOwner(owner);
    }
}
