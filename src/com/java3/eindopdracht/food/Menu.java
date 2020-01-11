package com.java3.eindopdracht.food;

import com.java3.eindopdracht.Allergie;

import java.util.ArrayList;

public class Menu {
    private final String itemOfOrder;
    private final double priceOfItem;
    public ArrayList items;

    public Menu(String itemOfOrder, double priceOfItem) {
        this.itemOfOrder = itemOfOrder;
        this.priceOfItem = priceOfItem;
    }

    public String getItemAndPrice() {
        return this.itemOfOrder + " €" + this.priceOfItem;
    }

    public double getPriceOfItem() {
        return this.priceOfItem;
    }

    public boolean checkItem(String ToCheck) {//kijkt of item in de lijst zit van bijv. burgers
        return items.contains(ToCheck);
    }

    public String getNameOfItem() {
        return this.itemOfOrder;
    }

    public void getAllegieList() {//printen lijst?
        Allergie allergie = new Allergie();
        allergie.printAllergieList();
    }

}
