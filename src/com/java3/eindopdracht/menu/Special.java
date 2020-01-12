package com.java3.eindopdracht.menu;

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
        put("Ontbijtcombi", 6d);
        put("Patat medium", 2.5);
    }};

    public Special(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        addAllergies(itemOfOrder);
    }

    @Override
    protected void addAllergies(String ItemName) {
        //TODO: add allergy for each product
        switch (ItemName) {

        }
    }

    public static boolean checkAllowedSpecial(String item) {
        return AvailableSpecials.keySet().contains(item);
    }

    public static double getSpecialPrice(String name) {
        return AvailableSpecials.get(name);
    }
}
