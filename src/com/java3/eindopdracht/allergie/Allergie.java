package com.java3.eindopdracht.allergie;

public class Allergie {
    private final AllergieType Type;
    private final String IngredientName;

    public Allergie(AllergieType type, String name) {
        Type = type;
        IngredientName = name;
    }

    public AllergieType getAllergyType() {
        return Type;
    }

    public String getIngredientName() {
        return IngredientName;
    }
}
