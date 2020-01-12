package com.java3.eindopdracht.menu;

import com.java3.eindopdracht.allergie.Allergie;
import com.java3.eindopdracht.allergie.AllergieType;

import java.util.HashSet;

public abstract class Menu {
    private final String itemOfOrder;
    private final double priceOfItem;
    private final HashSet<Allergie> Allergies;

    public Menu(String itemOfOrder, double priceOfItem) {
        this.itemOfOrder = itemOfOrder;
        this.priceOfItem = priceOfItem;

        Allergies = new HashSet<>();
    }

    public String getItemAndPrice() {
        return this.itemOfOrder + " €" + this.priceOfItem;
    }

    public double getPrice() {
        return this.priceOfItem;
    }

    public String getName() {
        return this.itemOfOrder;
    }

    public void addAllergy(String IngredientName, AllergieType type) {
        Allergies.add(new Allergie(type, IngredientName));
    }

    public String getFormattedAllergiesLabel() {
        StringBuilder label = new StringBuilder("Allergies in this product are: \n\r");
        for (Allergie a : Allergies) {
            label.append("  -").append(a.getIngredientName()).append(": ").append(a.getAllergyType()).append("\r\n");
        }
        return label.toString();
    }

    protected abstract void addAllergies(String ItemName);
}
