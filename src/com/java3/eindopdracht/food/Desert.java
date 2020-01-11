package com.java3.eindopdracht.food;

import java.util.ArrayList;

public class Desert extends Menu {
    public Desert(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        this.items = new ArrayList();
        this.items.add("Oublie hoorn");
        this.items.add("Vanilla cone");
        this.items.add("Sundae");
        this.items.add("Frozen Banana");
        this.items.add("Waterijsje");
    }

    @Override
    public boolean checkItem(String ToCheck) {
        return items.contains(ToCheck);
    }
}
