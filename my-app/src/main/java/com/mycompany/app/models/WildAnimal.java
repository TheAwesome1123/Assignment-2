package com.mycompany.app.models;

public class WildAnimal extends Animal {
    private int wildAnimalID, animalID;
    private String wildAnimalType;

    public int getWildAnimalID() {
        return wildAnimalID;
    }

    public void setWildAnimalID(int wildAnimalID) {
        this.wildAnimalID = wildAnimalID;
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public String getWildAnimalType() {
        return wildAnimalType;
    }

    public void setWildAnimalType(String wildAnimalType) {
        this.wildAnimalType = wildAnimalType;
    }
}
