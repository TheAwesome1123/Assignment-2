package com.mycompany.app.database.mybatis;

import com.mycompany.app.models.Owner;
import com.mycompany.app.models.Pet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SelectMethods {
    private static final Logger LOGGER = LogManager.getLogger(UpdateMethods.class);

    public static List<Object> selectStuff() {
        List<Object> listOfModels = new ArrayList<>();
        Owner owner = (SelectService.getOwner(1));
        Pet pet = SelectService.getPet(1);

        listOfModels.add(owner);
        listOfModels.add(pet);

        LOGGER.info("Pet type: " + pet.getPetType());
        LOGGER.info("Pet name: " + pet.getName());

        if(pet.getAge() != null) {
            LOGGER.info("Pet age: " + pet.getAge());
        }

        LOGGER.info("Pet owner ID: " + pet.getOwnerID());
        LOGGER.info("Pet animal ID: " + pet.getAnimalID() + "\n");

        LOGGER.info("Owner first name: " + owner.getFirstName());
        LOGGER.info("Owner last name: " + owner.getLastName());

        if(owner.getHeight() != null) {
            LOGGER.info("Owner height: " + owner.getHeight() + "\n");
        }

        LOGGER.info("");

        return listOfModels;
    }
}
