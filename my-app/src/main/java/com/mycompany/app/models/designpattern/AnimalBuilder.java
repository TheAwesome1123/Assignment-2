package com.mycompany.app.models.designpattern;

import com.mycompany.app.models.Animal;

public class AnimalBuilder {
    private int id;
    private String type, sex;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSex() {
        return sex;
    }

    public AnimalBuilder setID(int id) {
        this.id = id;
        return this;
    }

    public AnimalBuilder setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public AnimalBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Animal buildAnimal() {
        return new Animal(this);
    }
}
