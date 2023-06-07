package com.mycompany.app.database;

import com.mycompany.app.dao.OwnerDAO;
import com.mycompany.app.dao.PetDAO;
import com.mycompany.app.dao.WildAnimalDAO;

public class UpdateService {
    public static void updatePet(int id, int age) {
        new PetDAO().updatePetAge(id, age);
    }

    public static void updateOwner(int id, double height) {
        new OwnerDAO().updateOwnerHeight(id, height);
    }

    public static void updateWildAnimal(int id, int weight) {
        new WildAnimalDAO().updateWildAnimalWeight(id, weight);
    }
}
