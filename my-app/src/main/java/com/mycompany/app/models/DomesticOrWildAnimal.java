package com.mycompany.app.models;

import com.mycompany.app.models.designpattern.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "DomesticOrWild")
public class DomesticOrWildAnimal extends Model {
    @XmlElement(name = "ID")
    private int domesticOrWildID;
    @XmlElement(name = "Animal_ID")
    private Integer animalID;
    @XmlElement(name = "Type")
    private String domesticOrWildType;
    @XmlElement(name = "IsDomesticated")
    private boolean isDomesticated;

    @XmlTransient
    public int getDomesticOrWildID() {
        return domesticOrWildID;
    }

    public void setDomesticOrWildID(int id) {
        this.domesticOrWildID = id;
    }

    @XmlTransient
    public Integer getAnimalID() {
        return animalID;
    }

    public void setAnimalID(Integer animalID) {
        this.animalID = animalID;
    }

    @XmlTransient
    public String getDomesticOrWildType() {
        return domesticOrWildType;
    }

    public void setDomesticOrWildType(String type) {
        this.domesticOrWildType = type;
    }

    @XmlTransient
    public boolean isDomesticated() {
        return isDomesticated;
    }

    public void setDomesticated(boolean domesticated) {
        isDomesticated = domesticated;
    }
}
