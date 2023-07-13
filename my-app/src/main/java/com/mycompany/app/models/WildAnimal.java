package com.mycompany.app.models;

import com.mycompany.app.designpattern.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "WildAnimal")
public class WildAnimal extends Model {
    @XmlElement(name = "ID")
    private int wildAnimalID;
    @XmlElement(name = "Animal_ID")
    private Integer animalID;
    @XmlTransient
    private Integer weight;
    @XmlElement(name = "Type")
    private String wildAnimalType;

    @XmlTransient
    public Integer getWildAnimalID() {
        return wildAnimalID;
    }

    public void setWildAnimalID(Integer wildAnimalID) {
        this.wildAnimalID = wildAnimalID;
    }

    @XmlTransient
    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    @XmlTransient
    public String getWildAnimalType() {
        return wildAnimalType;
    }

    public void setWildAnimalType(String wildAnimalType) {
        this.wildAnimalType = wildAnimalType;
    }

    @XmlTransient
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
