package com.java3.eindopdracht.menu;

import java.util.HashMap;

public class Desert extends Menu {

    /**
     * A HashMap with the available deserts, initialized with an anonymous innerclass
     * see: double brace initialization
     */
    public static final HashMap<String, Double> AvailableDeserts = new HashMap<>() {{
        put("Oublie hoorn", 1d);
        put("Vanilla cone", 1.5);
        put("Sundae", 1.4);
        put("Frozen Banana", 2d);
        put("Waterijsje", 0.9);
    }};

    public Desert(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        addAllergies(itemOfOrder);
    }

    @Override
    protected void addAllergies(String ItemName) {
        //TODO: add allergy for each product
        switch (ItemName) {

        }
    }

    public static boolean checkAllowedDesert(String item) {
        return AvailableDeserts.keySet().contains(item);
    }

    public static double getDesertPrice(String name) {
        return AvailableDeserts.get(name);
    }
}
