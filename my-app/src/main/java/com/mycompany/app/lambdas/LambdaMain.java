package com.mycompany.app.lambdas;

import com.mycompany.app.abstracts.Animal;
import com.mycompany.app.animals.*;
import com.mycompany.app.enums.DogBreed;
import com.mycompany.app.enums.HomeContinent;
import com.mycompany.app.enums.Sex;
import com.mycompany.app.streams.GetFemaleAnimals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaMain {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Sam", DogBreed.BEAGLE, Sex.MALE, 5, "Robert",
                true);
        Dog dog2 = new Dog("Max", DogBreed.GOLDENRETRIEVER, Sex.MALE, 2, "Robert",
                false);
        Dog dog3 = new Labrador("Max", DogBreed.LABRADORRETRIEVER, Sex.MALE, 2, "Robert",
                false, "Chocolate");
        Elephant elephant = new Elephant(Sex.FEMALE, HomeContinent.AFRICA, "gray", 10);
        Squirrel squirrel = new Squirrel(Sex.MALE, HomeContinent.NORTHAMERICA,
                "light brown", 1);
        Bird eagle = new Bird(false, Sex.FEMALE, "Unknown", "Bald Eagle", 4,
                "N/A");

        List<Animal> list = new ArrayList<>();
        Animal[] animals = {dog1, dog2, dog3, elephant, squirrel, eagle};
        addToAnimalListForLambdas(list, animals);

        CustomLambdas.doBigDogChecks(dog1);
        CustomLambdas.doBigDogChecks(dog2);

        CustomLambdas.doCommonZooAnimalCheck(elephant);
        CustomLambdas.doCommonZooAnimalCheck(squirrel);
        CustomLambdas.doCommonZooAnimalCheck(eagle);
        CustomLambdas.doCommonZooAnimalCheck(dog1);
        CustomLambdas.doCommonZooAnimalCheck(dog3);

        CustomLambdas.getMales(list);
        GetFemaleAnimals.getFemaleAnimals(list);
    }

    public static void addToAnimalListForLambdas(List<Animal> list, Animal[] animalList) {
        list.addAll(Arrays.asList(animalList));
    }
}
