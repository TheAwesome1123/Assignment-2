package com.mycompany.app.models;

public class DomesticOrWildAnimalAndColorRelation {
    private int relationID, domesticOrWildAnimalID, colorID;

    public int getRelationID() {
        return this.relationID;
    }

    public void setRelationID(int newRelationID) {
        this.relationID = newRelationID;
    }

    public int getDomesticOrWildAnimalID() {
        return this.domesticOrWildAnimalID;
    }

    public void setDomesticOrWildAnimalID(int newWildAnimalID) {
        this.domesticOrWildAnimalID = newWildAnimalID;
    }

    public int getColorID() {
        return this.colorID;
    }

    public void setColorID(int newColorID) {
        this.colorID = newColorID;
    }
}
