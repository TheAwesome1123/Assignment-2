package com.mycompany.app.models;

public class Owner {
    int ownerID;
    String firstName, lastName;

    public int getOwnerID() {
        return this.ownerID;
    }

    public void setOwnerID(int newOwnerID) {
        this.ownerID = newOwnerID;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }
}