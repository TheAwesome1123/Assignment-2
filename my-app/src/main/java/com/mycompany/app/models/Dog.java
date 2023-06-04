package com.mycompany.app.models;

public class Dog extends Pet {
    private int dogID;
    private String breed;

    public int getDogID() {
        return dogID;
    }

    public void setDogID(int catID) {
        this.dogID = catID;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
