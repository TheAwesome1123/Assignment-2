package com.mycompany.app.models;

import com.mycompany.app.designpattern.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Dog")
public class Dog extends Model {
    @XmlElement(name = "ID")
    private int dogID;
    @XmlElement(name = "Pet_ID")
    private Integer petID;
    @XmlElement(name = "Breed")
    private String breed;

    @XmlTransient
    public int getDogID() {
        return dogID;
    }

    public void setDogID(int dogID) {
        this.dogID = dogID;
    }

    @XmlTransient
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @XmlTransient
    public Integer getPetID() {
        return petID;
    }

    public void setPetID(Integer petID) {
        this.petID = petID;
    }
}
