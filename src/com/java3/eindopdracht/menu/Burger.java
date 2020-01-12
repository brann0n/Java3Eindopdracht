package com.java3.eindopdracht.menu;

import com.java3.eindopdracht.allergie.AllergieType;

import java.util.HashMap;

public class Burger extends Menu {

    /**
     * A HashMap with the available burgers, initialized with an anonymous innerclass
     * see: double brace initialization
     */
    public static final HashMap<String, Double> AvailableBurgers = new HashMap<>() {{
        put("Big Mac", 6.50);
        put("Big Tasty", 12.50);
        put("Double Quarter Pounder", 8d);
        put("XXL Meat Burger", 15.99);
        put("Single Big Tasty", 5.50);
    }};

    public Burger(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        addAllergies(itemOfOrder);
    }

    @Override
    protected void addAllergies(String ItemName) {
        //TODO: add allergy for each product
        switch (ItemName) {
            case "Big Mac":
                addAllergy("Bread", AllergieType.GLUTEN);
                break;
            case "Big Tasty":
                break;
            case "Double Quarter Pounder":
                break;
            case "XXL Meat Burger":
                break;
            case "Single Big Tasty":
                break;

        }
    }

    public static boolean checkAllowedBurger(String item) {
        return AvailableBurgers.keySet().contains(item);
    }

    public static double getBurgerPrice(String name) {
        return AvailableBurgers.get(name);
    }
}
