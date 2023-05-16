package com.mycompany.app.enums;

public enum DogBreed {
    GERMANSHEPHERD("Tan/Black"), GOLDENRETRIEVER("Gold"), PUG("White"), BEAGLE("Brown/White"),
        LABRADORRETRIEVER("Various");

    private final String color;

    DogBreed(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public int getNumColors() {
        String[] splitColorString = this.color.split("/");
        return splitColorString.length;
    }
}
