package com.mycompany.app.streams;

import com.mycompany.app.abstracts.Pet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GiveOwnerToPetsWithoutOne {
    private static final Logger LOGGER = LogManager.getLogger(GiveOwnerToPetsWithoutOne.class);

    public static void giveOwnerToPetWithoutOne(List<Pet> list, String name) {
        list.stream().filter(pet -> pet.getOwner().equals("N/A")).forEach(petWithNoOwner -> {
            petWithNoOwner.setOwner(name);
        });
    }
}
