package com.mycompany.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class DomesticAnimal {
    @JsonProperty("ID")
    private int domesticAnimalID;
    @JsonProperty("Owner ID")
    private Integer ownerID;
    @JsonProperty("Domestic or Wild Animal ID")
    private Integer domesticOrWildID;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Date of Birth")
    private Date dateOfBirth;

    public int getDomesticAnimalID() {
        return domesticAnimalID;
    }

    public void setDomesticAnimalID(int domesticAnimalID) {
        this.domesticAnimalID = domesticAnimalID;
    }

    public Integer getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Integer ownerID) {
        this.ownerID = ownerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDomesticOrWildID() {
        return domesticOrWildID;
    }

    public void setDomesticOrWildID(Integer domesticOrWildID) {
        this.domesticOrWildID = domesticOrWildID;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
