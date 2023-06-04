package com.mycompany.app.models;

public class DomesticAnimal extends DomesticOrWild {
    private int domesticAnimalID, ownerID;
    private String name;

    public int getDomesticAnimalID() {
        return domesticAnimalID;
    }

    public void setDomesticAnimalID(int domesticAnimalID) {
        this.domesticAnimalID = domesticAnimalID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
