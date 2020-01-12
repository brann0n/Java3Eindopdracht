package com.java3.eindopdracht.menu;

import java.util.HashMap;

public class Snack extends Menu {

    /**
     * A HashMap with the available snacks, initialized with an anonymous innerclass
     * see: double brace initialization
     */
    public static final HashMap<String, Double> AvailableSnacks = new HashMap<>() {{
        put("Euroknaller", 1d);
        put("McChicken", 2d);
        put("10 Chicken Nuggets", 5d);
        put("6 Chicken Nuggets", 3.5);
        put("McKroket", 1.99);
    }};

    public Snack(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        //TODO: add allergy for each product
    }

    @Override
    protected void addAllergies(String ItemName) {
        //TODO: add allergy for each product
        switch (ItemName) {

        }
    }

    public static boolean checkAllowedSnack(String item) {
        return AvailableSnacks.keySet().contains(item);
    }

    public static double getSnackPrice(String name) {
        return AvailableSnacks.get(name);
    }
}
