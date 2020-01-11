package com.java3.eindopdracht.food;

import java.util.ArrayList;

public class Burger extends Menu{
    public Burger(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        this.items = new ArrayList();
        this.items.add("Big Mac");
        this.items.add("Big Tasty");
        this.items.add("Double Quater Pounder");
        this.items.add("XXL Meat Burger");
        this.items.add("Single Big Tasty");
    }

    @Override
    public boolean checkItem(String ToCheck) {
        return items.contains(ToCheck);
    }
}
