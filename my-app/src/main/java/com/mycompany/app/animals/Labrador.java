package com.mycompany.app.animals;

import com.mycompany.app.enums.DogBreed;
import com.mycompany.app.enums.Sex;

public final class Labrador extends Dog {
    // Properties.
    private String color;

    public Labrador(String name, DogBreed breed, Sex sex, int age, String owner, boolean fightsWithCats, String color) {
        super(name, breed, sex, age, owner, fightsWithCats);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }
}
