package com.java3.eindopdracht.menu;

import com.java3.eindopdracht.allergie.AllergieType;

import java.util.HashMap;

public class Snack extends Menu {

    /**
     * A HashMap with the available snacks, initialized with an anonymous innerclass
     * see: double brace initialization
     */
    public static final HashMap<String, Double> AvailableSnacks = new HashMap<String, Double>() {{
        put("Euroknaller", 1d);
        put("McChicken", 2d);
        put("10 Chicken Nuggets", 5d);
        put("6 Chicken Nuggets", 3.5);
        put("Chocolate Brownie", 1.50);
    }};

    public Snack(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
       }

    @Override
    protected void addAllergies(String ItemName) {
        switch (ItemName) {
            case "Euroknaller":
                addAllergy("Bread", AllergieType.GLUTEN);
                addAllergy("Bun", AllergieType.SESAME);
                break;
            case "McChicken":
                addAllergy("Coated Chicken Patty", AllergieType.GLUTEN);
                addAllergy("Coated Chicken Patty", AllergieType.MUSTARD);
                addAllergy("Sesame Bun", AllergieType.SESAME);
                addAllergy("Sandwich Sauce", AllergieType.EGG);
                break;
            case "10 Chicken Nuggets":
                addAllergy("Chicken Breast Meat", AllergieType.GLUTEN);
                break;
            case "6 Chicken Nuggets":
                addAllergy("Chicken Meat", AllergieType.GLUTEN);
                break;
            case "Chocolate Brownie":
                addAllergy("Chocolate Brownie", AllergieType.MILK);
                addAllergy("Chocolate Brownie", AllergieType.GLUTEN);
                addAllergy("Chocolate Brownie", AllergieType.MILK);
                addAllergy("Chocolate Brownie", AllergieType.EGG);
                addAllergy("Chocolate Brownie", AllergieType.SOYA);
                break;
        }
    }

    public static boolean checkAllowedSnack(String item) {
        return AvailableSnacks.keySet().contains(item);
    }

    public static double getSnackPrice(String name) {
        return AvailableSnacks.get(name);
    }
}
