package com.java3.eindopdracht.menu;

import java.util.HashMap;

public class Drink extends Menu {

    /**
     * A HashMap with the available drinks, initialized with an anonymous innerclass
     * see: double brace initialization
     */
    public static final HashMap<String, Double> AvailableDrinks = new HashMap<>() {{
        put("Milkshake", 2.5);
        put("Cola", 2d);
        put("Sinas", 2d);
        put("Sprite", 2d);
    }};

    public Drink(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        addAllergies(itemOfOrder);
    }

    @Override
    protected void addAllergies(String ItemName) {
        //TODO: add allergy for each product
        switch (ItemName) {

        }
    }

    public static boolean checkAllowedDrink(String item) {
        return AvailableDrinks.keySet().contains(item);
    }

    public static double getDrinkPrice(String name) {
        return AvailableDrinks.get(name);
    }
}
