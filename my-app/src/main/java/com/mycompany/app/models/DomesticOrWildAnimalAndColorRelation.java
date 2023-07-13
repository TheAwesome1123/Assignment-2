package com.mycompany.app.models;

import com.mycompany.app.designpattern.Model;

public class DomesticOrWildAnimalAndColorRelation extends Model {
    private int relationID;
    private Integer domesticOrWildAnimalID, colorID;

    public int getRelationID() {
        return this.relationID;
    }

    public void setRelationID(int newRelationID) {
        this.relationID = newRelationID;
    }

    public Integer getDomesticOrWildAnimalID() {
        return this.domesticOrWildAnimalID;
    }

    public void setDomesticOrWildAnimalID(Integer newWildAnimalID) {
        this.domesticOrWildAnimalID = newWildAnimalID;
    }

    public Integer getColorID() {
        return this.colorID;
    }

    public void setColorID(Integer newColorID) {
        this.colorID = newColorID;
    }
}
