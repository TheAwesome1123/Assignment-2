package com.mycompany.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.app.designpattern.Model;

public class WildAnimalAndColorRelation extends Model {
    @JsonProperty("ID")
    private int relationID;
    @JsonProperty("WildAnimal ID")
    private Integer wildAnimalID;
    @JsonProperty("Color ID")
    private Integer colorID;

    public int getRelationID() {
        return this.relationID;
    }

    public void setRelationID(int newRelationID) {
        this.relationID = newRelationID;
    }

    public Integer getWildAnimalID() {
        return this.wildAnimalID;
    }

    public void setWildAnimalID(Integer newWildAnimalID) {
        this.wildAnimalID = newWildAnimalID;
    }

    public Integer getColorID() {
        return this.colorID;
    }

    public void setColorID(Integer newColorID) {
        this.colorID = newColorID;
    }
}
