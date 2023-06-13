package com.mycompany.app.xml.animalsandproperties;

import com.mycompany.app.models.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@XmlRootElement(name = "AnimalsAndProperties")
public class AnimalsAndProperties {
    @XmlElement(name = "Pet")
    private Pet pet;
    @XmlElement(name = "Dog")
    private Dog dog;
    @XmlElement(name = "WildAnimal")
    private WildAnimal wildAnimal;
    @XmlElement(name = "DomesticOrWild")
    private DomesticOrWild domesticOrWild;
    @XmlElement(name = "HomeContinent")
    private HomeContinent homeContinent;

    @XmlTransient
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @XmlTransient
    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @XmlTransient
    public WildAnimal getWildAnimal() {
        return wildAnimal;
    }

    public void setWildAnimal(WildAnimal wildAnimal) {
        this.wildAnimal = wildAnimal;
    }

    @XmlTransient
    public DomesticOrWild getDomesticOrWild() {
        return domesticOrWild;
    }

    public void setDomesticOrWild(DomesticOrWild domesticOrWild) {
        this.domesticOrWild = domesticOrWild;
    }

    @XmlTransient
    public HomeContinent getHomeContinent() {
        return homeContinent;
    }

    public void setHomeContinent(HomeContinent homeContinent) {
        this.homeContinent = homeContinent;
    }
}
