package com.mycompany.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WildAnimalAndColorRelation {
    @JsonProperty("ID")
    private int relationID;
    @JsonProperty("WildAnimal ID")
    private int  wildAnimalID;
    @JsonProperty("Color ID")
    private int colorID;

    public int getRelationID() {
        return this.relationID;
    }

    public void setRelationID(int newRelationID) {
        this.relationID = newRelationID;
    }

    public int getWildAnimalID() {
        return this.wildAnimalID;
    }

    public void setWildAnimalID(int newWildAnimalID) {
        this.wildAnimalID = newWildAnimalID;
    }

    public int getColorID() {
        return this.colorID;
    }

    public void setColorID(int newColorID) {
        this.colorID = newColorID;
    }
}
