package com.java3.eindopdracht;

import com.java3.eindopdracht.food.*;

import java.util.HashSet;

public class Order {
    private HashSet<Menu> thisOrder = new HashSet();
    private String dCode = "";
    private double totalPrice;
    PickUpLocation pickUp = new PickUpLocation("Main window");
    Percentage percentage = new Percentage();
    Price DiscPrice = new Price();
    public Order() {

    }

    public void addDrink(String drinkName, double priceOfItem) {//voeg drink toe aan order

        Drink drinkje = new Drink(drinkName, priceOfItem);
        if (drinkje.checkItem(drinkName)) {
            thisOrder.add(drinkje);
        } else {
            System.out.println("not a drink.");
        }

    }

    public void addBurger(String burgerName, double priceOfItem) {//voeg burger toe
        Burger burger = new Burger(burgerName, priceOfItem);
        if (burger.checkItem(burgerName)) {
            thisOrder.add(burger);
        } else {
            System.out.println("not a burger.");
        }
    }

    public void addSnack(String snackName, double priceOfItem) {//voeg snack toe
        Snack snack = new Snack(snackName, priceOfItem);
        if (snack.checkItem(snackName)) {
            thisOrder.add(snack);
        } else {
            System.out.println("not a snack.");
        }
    }

    public void addSpecial(String specialName, double priceOfItem) {//voeg special toe
        Special special = new Special(specialName, priceOfItem);
        if (special.checkItem(specialName)) {
            thisOrder.add(special);
        } else {
            System.out.println("not a special.");
        }
    }

    public void addDesert(String desertName, double priceOfItem) {//voeg desert toe aan order
        Desert desert = new Desert(desertName, priceOfItem);
        if (desert.checkItem(desertName)) {
            thisOrder.add(desert);
        } else {
            System.out.println("not a desert.");
        }
    }

    public void printThisOrder() {//deze order word uitgeprint

        System.out.println("\nThis order contains the following items:");

        thisOrder.forEach((i) -> {
            System.out.println(i.getItemAndPrice());
        });
        System.out.println("total: €" + getTotalPrice() + "\nThis Order can be picked up on location; " + pickUp.getPickUpLocation());

    }

    public double getTotalPrice() {//totaal prijs word berekent
        totalPrice = 0;
        thisOrder.forEach((i) -> {

            totalPrice += i.getPriceOfItem();
        });

        if (!dCode.equals("")) {//kijken of er een code ingevoerd is
            //TODO: kijken of de code ook voorkomt in de lijst
            //check ^
            //Percentage.calculateDiscount(getAmountOfDiscount, totalPrice)
            //OR
            //
            //Price.calculateDiscount(getAmountOfDiscount, totalPrice)
            System.out.println("Your discount code(" + dCode + ") is used for ****");
        }

        return totalPrice;
    }

    public void getAllergList() {//TODO: dit.
        Menu nothing = new Menu("", 0);
        nothing.getAllegieList();
    }

    public void setOtherPickUpLocation(String location) {//set pick up locatie
        pickUp.setDifferentLocation(location);
        //System.out.println("Pick-up location is set on " + pickUp.getPickUpLocation());
    }

    public void setDiscountcode(String dCode) {//set kortingcode voor deze order
        this.dCode = dCode;
    }

}
