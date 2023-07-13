package com.mycompany.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.app.designpattern.Model;

public class Cat extends Model {
    @JsonProperty("ID")
    private int catID;
    @JsonProperty("Pet ID")
    private Integer petID;
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

    public Integer getPetID() {
        return petID;
    }

    public void setPetID(Integer petID) {
        this.petID = petID;
    }
}
