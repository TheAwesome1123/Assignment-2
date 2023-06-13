package com.mycompany.app.models;

import com.mycompany.app.xml.pet.DateAdapter2;
import com.mycompany.app.xml.pet.DateOfBirthAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.Date;

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

    @XmlElement(name = "DateOfBirth")
    @XmlJavaTypeAdapter(DateOfBirthAdapter.class)
    private Date dateOfBirth;

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

    @XmlTransient
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
