package com.mycompany.app.models;

public class HomeContinent {
    private int continentID, wildAnimalID;
    private String continent;

    public String getContinent() {
        return this.continent;
    }

    public void setContinent(String newContinent) {
        this.continent = newContinent;
    }

    public int getContinentID() {
        return this.continentID;
    }

    public void setContinentID(int newContinentID) {
        this.continentID = newContinentID;
    }

    public int getWildAnimalID() {
        return this.wildAnimalID;
    }

    public void setWildAnimalID(int newWildAnimalID) {
        this.wildAnimalID = newWildAnimalID;
    }
}