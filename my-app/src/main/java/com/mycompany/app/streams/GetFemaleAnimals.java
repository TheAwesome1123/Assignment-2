package com.mycompany.app.streams;

import com.mycompany.app.abstracts.Animal;
import com.mycompany.app.enums.Sex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GetFemaleAnimals {
    private static final Logger LOGGER = LogManager.getLogger(GetFemaleAnimals.class);

    public static void getFemaleAnimals(List<Animal> list) {
        LOGGER.info("All female animals: ");
        list.stream().filter(animal -> animal.getSex() == Sex.FEMALE).forEach(female ->
            LOGGER.info(female.toString()));
    }
}
