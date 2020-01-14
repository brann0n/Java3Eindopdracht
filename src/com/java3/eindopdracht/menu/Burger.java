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
        put("XXL Meat Burger", 10d);
        put("Single Big Tasty", 5.50);
    }};

    public Burger(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        addAllergies(itemOfOrder);
    }

    @Override
    protected void addAllergies(String ItemName) {
        switch (ItemName) {
            case "Big Mac":
                addAllergy("Bread", AllergieType.GLUTEN);
                addAllergy("Big Mac Bun", AllergieType.SESAME);
                addAllergy("Big Mac Sauce", AllergieType.EGG);
                addAllergy("Big Mac Sauce", AllergieType.MUSTARD);
                addAllergy("Cheddar Cheese Slice", AllergieType.MILK);
                break;
            case "Big Tasty":
                addAllergy("Bread", AllergieType.GLUTEN);
                addAllergy("Big Tasty Bun", AllergieType.SESAME);
                addAllergy("Big Tasty Sauce", AllergieType.EGG);
                addAllergy("Cheddar Cheese Slice", AllergieType.MILK); break;
            case "Double Quarter Pounder":
                addAllergy("Bread", AllergieType.GLUTEN);
                addAllergy("Quarter Pounder Bun", AllergieType.SESAME);
                addAllergy("Mustard", AllergieType.MUSTARD);
                addAllergy("Cheddar Cheese Slice", AllergieType.MILK);
                break;
            case "XXL Meat Burger":
                addAllergy("Bread", AllergieType.GLUTEN);
                addAllergy("XXL Meat Burger Bun", AllergieType.SESAME);
                addAllergy("XXL Meat Burger Sauce", AllergieType.EGG);
                addAllergy("XXL Meat Burger Sauce", AllergieType.MUSTARD);
                addAllergy("Cheddar Cheese Slice", AllergieType.MILK);
                break;
            case "Single Big Tasty":
                addAllergy("Bread", AllergieType.GLUTEN);
                addAllergy("Single Big Tasty Bun", AllergieType.SESAME);
                addAllergy("Big Tasty Sauce", AllergieType.EGG);
                addAllergy("Cheddar Cheese Slice", AllergieType.MILK);
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
