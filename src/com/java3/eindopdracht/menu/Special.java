package com.java3.eindopdracht.menu;

import com.java3.eindopdracht.allergie.AllergieType;

import java.util.HashMap;

public class Special extends Menu {

    /**
     * A HashMap with the available specials, initialized with an anonymous innerclass
     * see: double brace initialization
     */
    public static final HashMap<String, Double> AvailableSpecials = new HashMap<String, Double>() {{
        put("KinderMenu", 10d);
        put("Patat groot", 3d);
        put("Patat klein", 2d);
        put("Carrot Bag", 1d);
        put("Patat medium", 2.5);
    }};

    public Special(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        addAllergies(itemOfOrder);
    }

    @Override
    protected void addAllergies(String ItemName) {
        switch (ItemName) {
            case "KinderMenu":
                break;
            case "Patat groot":
                break;
            case "Patat klein":
                break;
            case "Carrot Bag":
                break;
            case "Patat medium":
                break;
        }
    }

    public static boolean checkAllowedSpecial(String item) {
        return AvailableSpecials.keySet().contains(item);
    }

    public static double getSpecialPrice(String name) {
        return AvailableSpecials.get(name);
    }
}
