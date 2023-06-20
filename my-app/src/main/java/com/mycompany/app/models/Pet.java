package com.mycompany.app.models;

import com.mycompany.app.xml.pet.DateOfBirthAdapter;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "Pet")
public class Pet {
    @XmlElement(name = "ID")
    private int petID;

    @XmlElement(name = "Owner_ID")
    private Integer ownerID;

    @XmlElement(name = "Animal_ID")
    private Integer animalID;

    @XmlElement(name = "Type")
    private String petType;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Age")
    private Integer age;

    @XmlElement(name = "DateOfBirth")
    @XmlJavaTypeAdapter(DateOfBirthAdapter.class)
    private Date dateOfBirth;

    @XmlTransient
    public Integer getPetID() {
        return petID;
    }

    public void setPetID(Integer petID) {
        this.petID = petID;
    }

    @XmlTransient
    public Integer getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Integer ownerID) {
        this.ownerID = ownerID;
    }

    @XmlTransient
    public Integer getAnimalID() {
        return animalID;
    }

    public void setAnimalID(Integer animalID) {
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
    public Integer getAge() {
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
