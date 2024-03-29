package com.mycompany.app.models;

import com.mycompany.app.designpattern.Model;

public class DomesticOrWildAnimalColor extends Model {
    private int colorID;
    private String color, shade;

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
