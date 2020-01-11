package com.java3.eindopdracht.food;

import java.util.ArrayList;

public class Drink extends Menu {
    private ArrayList items;

    public Drink(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        this.items = new ArrayList();
        this.items.add("Milkshake");
        this.items.add("Cola");
        this.items.add("Sinas");
        this.items.add("Sprite");
        this.items.add("Milkshake");
    }

    @Override
    public boolean checkItem(String ToCheck) {
        return items.contains(ToCheck);
    }

}
