package com.mycompany.app.designpattern;

import com.mycompany.app.models.Pet;

public class PetController {
    private Pet petModel;
    private PetViewer viewer;
    public PetController(Pet pet, PetViewer viewer) {
        this.petModel = pet;
        this.viewer = viewer;
    }

    public void printUpdatedPetInfo() {
        this.viewer.printPetInfo(this.petModel);
    }

    public void setPetType(String petType) {
        this.petModel.setPetType(petType);
    }

    public void setName(String name) {
        this.petModel.setName(name);
    }

    public void setAge(Integer age) {
        this.petModel.setAge(age);
    }
}
