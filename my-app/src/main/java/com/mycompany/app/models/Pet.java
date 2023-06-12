package com.mycompany.app.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Pet")
public class Pet {
    @XmlElement(name = "ID")
    private int petID;

    @XmlElement(name = "Owner_ID")
    private int ownerID;

    @XmlElement(name = "Animal_ID")
    private int animalID;

    @XmlElement(name = "Type")
    private String petType;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Age")
    private int age;

    @XmlTransient
    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    @XmlTransient
    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    @XmlTransient
    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    @XmlTransient
    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    @XmlTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
