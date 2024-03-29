package com.mycompany.app.models;

import com.mycompany.app.designpattern.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "HomeContinent")
public class HomeContinent extends Model {
    @XmlElement(name = "ID")
    private int continentID;
    @XmlElement(name = "WildAnimal_ID")
    private Integer wildAnimalID;
    @XmlElement(name = "HomeContinent")
    private String continent;

    @XmlTransient
    public String getContinent() {
        return this.continent;
    }

    public void setContinent(String newContinent) {
        this.continent = newContinent;
    }

    @XmlTransient
    public int getContinentID() {
        return this.continentID;
    }

    public void setContinentID(int newContinentID) {
        this.continentID = newContinentID;
    }

    @XmlTransient
    public Integer getWildAnimalID() {
        return this.wildAnimalID;
    }

    public void setWildAnimalID(Integer newWildAnimalID) {
        this.wildAnimalID = newWildAnimalID;
    }
}