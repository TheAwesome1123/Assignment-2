package com.mycompany.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat {
    @JsonProperty("ID")
    private int catID;
    @JsonProperty("Pet ID")
    private int petID;
    @JsonProperty("Breed")
    private String breed;

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }
}
