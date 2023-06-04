package com.mycompany.app.models;

public class WildAnimalAndColorRelation {
    private int relationID, wildAnimalID, colorID;

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
