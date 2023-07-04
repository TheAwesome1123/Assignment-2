package com.mycompany.app.models;

import com.mycompany.app.models.designpattern.AnimalBuilder;
import com.mycompany.app.models.designpattern.Model;

public class Animal extends Model {
    private int id;
    private String type, sex;

    public Animal(AnimalBuilder builder) {
        this.id = builder.getId();
        this.sex = builder.getSex();
        this.type = builder.getType();
    }

    public Animal() {

    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
