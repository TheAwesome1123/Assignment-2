package com.mycompany.app.models.designpattern;

import com.mycompany.app.models.*;

public class ModelFactory {
    public Model createModel(String name) {
        switch (name) {
            case "Animal" -> {
                return new Animal();
            }
            case "Pet" -> {
                return new Pet();
            }
            case "Cat" -> {
                return new Cat();
            }
            case "Dog" -> {
                return new Dog();
            }
            case "Owner" -> {
                return new Owner();
            }
            case "WildAnimal" -> {
                return new WildAnimal();
            }
            case "HomeContinent" -> {
                return new HomeContinent();
            }
            case "WildAnimalColor" -> {
                return new WildAnimalColor();
            }
            case "WildAnimalAndColorRelation" -> {
                return new WildAnimalAndColorRelation();
            }
            case "DomesticOrWildAnimal" -> {
                return new DomesticOrWildAnimal();
            }
            case "DomesticAnimal" -> {
                return new DomesticAnimal();
            }
            case "DomesticOrWildAnimalColor" -> {
                return new DomesticOrWildAnimalColor();
            }
            case "DomesticOrWildAnimalAndColorRelation" -> {
                return new DomesticOrWildAnimalAndColorRelation();
            }
            default -> {
                return null;
            }
        }
    }

    public static ModelFactory getModelFactory() {
        return new ModelFactory();
    }

}
