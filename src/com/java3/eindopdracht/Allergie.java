package com.java3.eindopdracht;

public class Allergie {
    public Allergie(){

    }

    public void printAllergieList(){//TODO: ALLES HIER
        System.out.println("we can take into account the following allergies: " + AllergieKind.Gluten + ", " + AllergieKind.Vegan + ", " + AllergieKind.Nuts+ ", " + AllergieKind.Milk+ ", " + AllergieKind.Lupin + ", " + AllergieKind.Mustard);
    }
    enum AllergieKind {
        Gluten,
        Vegan,
        Nuts,
        Milk,
        Lupin,
        Mustard
    }
}
