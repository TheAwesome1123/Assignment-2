package com.mycompany.app.streams;

import com.mycompany.app.abstracts.Animal;
import java.util.List;
import java.util.Optional;

public class GetSomeAnimalFromList {
    public static Optional<Animal> getAnimalFromList(List<Animal> list) {
        return list.stream().findAny();
    }
}
