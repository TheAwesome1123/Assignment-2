package com.mycompany.app.streams;

import com.mycompany.app.abstracts.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.stream.Stream;

public class AreAnimalsInListUnique {
    private static final Logger LOGGER = LogManager.getLogger(AreAnimalsInListUnique.class);

    public static String resultOfThereBeingUniqueAnimals(List<Animal> list) {
        Stream<Animal> uniqueAnimals = list.stream().distinct();

        if(uniqueAnimals.count() == list.size()) {
            return "All animals are unique.";
        }
        else {
            return "There are at least 2 identical animals.";
        }
    }
}
