package com.mycompany.app.enums;

public enum Sex {
    MALE(false), FEMALE(true);

    private final boolean canGiveBirth;

    Sex(boolean canGiveBirth) {
        this.canGiveBirth = canGiveBirth;
    }

    public boolean getAbilityToGiveBirth() {
        return this.canGiveBirth;
    }

}
