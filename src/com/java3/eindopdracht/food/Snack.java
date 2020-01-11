package com.java3.eindopdracht.food;

import java.util.ArrayList;

public class Snack extends Menu {
    public Snack(String itemOfOrder, double priceOfItem) {
        super(itemOfOrder, priceOfItem);
        this.items = new ArrayList();
        this.items.add("Euroknaller");
        this.items.add("McChicken");
        this.items.add("10 Chicken Nuggets");
        this.items.add("6 Chicken Nuggets");
        this.items.add("McKroket");
    }

    @Override
    public boolean checkItem(String ToCheck) {
        return items.contains(ToCheck);
    }
}
