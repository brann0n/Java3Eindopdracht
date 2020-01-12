package com.java3.eindopdracht.allergie;

public enum AllergieType {
    /**
     * All the possible allergies in a list
     */
    //TODO: add actual allergies
    GLUTEN("Gluten"),
    VEGAN("Vegan"),
    NUTS("Nuts"),
    MILK("Milk"),
    LUPIN("Lupin"),
    MUSTARD("Mustard");

    private final String value;

    AllergieType(String name) {
        value = name;
    }

    @Override
    public String toString() {
        return value;
    }
}
