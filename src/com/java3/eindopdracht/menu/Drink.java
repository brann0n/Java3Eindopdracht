package com.java3.eindopdracht.menu;

import com.java3.eindopdracht.allergie.AllergieType;

import java.util.HashMap;

public class Drink extends Menu {

    /**
     * A HashMap with the available drinks, initialized with an anonymous innerclass
     * see: double brace initialization
     */
    public static final HashMap<String, Double> AvailableDrinks = new HashMap<String, Double>() {{
        put("Milkshake", 3d);
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
       switch (ItemName) {
           case "Milkshake":
               addAllergy("Ice Cream", AllergieType.MILK);
               break;
           case "Cola":
               break;
           case "Sinas":
               break;
           case "Sprite":
               break;
        }
    }

    public static boolean checkAllowedDrink(String item) {
        return AvailableDrinks.keySet().contains(item);
    }

    public static double getDrinkPrice(String name) {
        return AvailableDrinks.get(name);
    }
}
