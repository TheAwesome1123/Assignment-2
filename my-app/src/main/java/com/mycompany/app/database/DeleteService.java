package com.mycompany.app.database;

import com.mycompany.app.dao.AnimalDAO;
import com.mycompany.app.dao.DogDAO;
import com.mycompany.app.dao.PetDAO;
import com.mycompany.app.models.Dog;
import com.mycompany.app.models.Pet;

public class DeleteService {
    public static void deleteDog(int dogID) {
        DogDAO dogDAO = new DogDAO();
        Dog dog = dogDAO.getDog(dogID);
        int petID = dog.getPetID();

        PetDAO petDAO = new PetDAO();
        Pet pet = petDAO.getPet(petID);
        int animalID = pet.getAnimalID();

        AnimalDAO animalDAO = new AnimalDAO();
        dogDAO.deleteDog(dogID);
        petDAO.deletePet(petID);
        animalDAO.deleteAnimal(animalID);
    }
}
