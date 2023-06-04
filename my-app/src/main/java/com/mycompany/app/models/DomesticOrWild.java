package com.mycompany.app.models;

public class DomesticOrWild extends Animal {
    private int domesticOrWildID;
    private int animalID;
    private String domesticOrWildType;
    private boolean isDomesticated;

    public int getDomesticOrWildID() {
        return domesticOrWildID;
    }

    public void setDomesticOrWildID(int id) {
        this.domesticOrWildID = id;
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public String getDomesticOrWildType() {
        return domesticOrWildType;
    }

    public void setDomesticOrWildType(String type) {
        this.domesticOrWildType = type;
    }

    public boolean isDomesticated() {
        return isDomesticated;
    }

    public void setDomesticated(boolean domesticated) {
        isDomesticated = domesticated;
    }
}
