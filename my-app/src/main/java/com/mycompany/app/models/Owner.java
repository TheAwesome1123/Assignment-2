package com.mycompany.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Owner {
    @JsonProperty("ID")
    private int ownerID;
    @JsonProperty("Height")
    private double height;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("CitiesVisited")
    private List<String> citiesVisited;

    public int getOwnerID() {
        return this.ownerID;
    }

    public void setOwnerID(int newOwnerID) {
        this.ownerID = newOwnerID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public List<String> getCitiesVisited() {
        return citiesVisited;
    }

    public void setCitiesVisited(List<String> citiesVisited) {
        this.citiesVisited = citiesVisited;
    }
}