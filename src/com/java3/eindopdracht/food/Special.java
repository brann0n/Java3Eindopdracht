package com.java3.eindopdracht.food;

import java.util.ArrayList;

public class Special extends Menu{
    public Special(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        this.items = new ArrayList();
        this.items.add("KinderMenu");
        this.items.add("Patat groot");
        this.items.add("Patat klein");
        this.items.add("Ontbijtcombi");
        this.items.add("Patat medium");
    }

    @Override
    public boolean checkItem(String ToCheck) {
        return items.contains(ToCheck);
    }
}
