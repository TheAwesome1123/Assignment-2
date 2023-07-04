package com.mycompany.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.app.models.designpattern.Model;

public class WildAnimalColor extends Model {
    @JsonProperty("ID")
    private int colorID;
    @JsonProperty("Color")
    private String color;
    @JsonProperty("Shade")
    private String shade;

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShade() {
        return shade;
    }

    public void setShade(String shade) {
        this.shade = shade;
    }
}
