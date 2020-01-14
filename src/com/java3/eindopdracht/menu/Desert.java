package com.java3.eindopdracht.menu;

import com.java3.eindopdracht.allergie.AllergieType;

import java.util.HashMap;

public class Desert extends Menu {

    /**
     * A HashMap with the available deserts, initialized with an anonymous innerclass
     * see: double brace initialization
     */
    public static final HashMap<String, Double> AvailableDeserts = new HashMap<String, Double>() {{
        put("Oublie hoorn", 1d);
        put("Vanilla cone", 1.5);
        put("Sundae", 1.4);
        put("McFlurry", 2d);
        put("Waterijsje", 0.9);
    }};

    public Desert(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        addAllergies(itemOfOrder);
    }

    @Override
    protected void addAllergies(String ItemName) {
        switch (ItemName) {
            case "Oublie hoorn":
                addAllergy("Ice Cream", AllergieType.MILK);
                addAllergy("Ice Cream Cone", AllergieType.SOYA);
                addAllergy("Sprinkles", AllergieType.NUTS);
                break;
            case "Vanilla cone":
                addAllergy("Ice Cream", AllergieType.MILK);
                addAllergy("Ice Cream Cone", AllergieType.SOYA);
                break;
            case "Sundae":
                addAllergy("Ice Cream", AllergieType.MILK);
                break;
            case "Waterijsje":
                break;
            case "McFlurry":
                addAllergy("Ice Cream", AllergieType.MILK);
                addAllergy("Oreo Crumb", AllergieType.GLUTEN);
                addAllergy("Oreo Crumb", AllergieType.SOYA);
                break;
        }
    }

    public static boolean checkAllowedDesert(String item) {
        return AvailableDeserts.keySet().contains(item);
    }

    public static double getDesertPrice(String name) {
        return AvailableDeserts.get(name);
    }
}
