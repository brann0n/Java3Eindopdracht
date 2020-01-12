package com.java3.eindopdracht;

public class MacOrderSystem {

    public static void main(String[] args){
        Shop MacEmmen = new Shop();

        MacEmmen.addDiscountCode("10OFF", "€10");
        MacEmmen.addDiscountCode("HALFTHEPRICE", "50%");
        MacEmmen.printDiscountList();

        Order order1 = MacEmmen.createOrder();
        order1.addBurger("Big Mac", 2);
        order1.addDrink("Sinas", 4);
        order1.addDiscountCode("HALFTHEPRICE");
        order1.addDiscountCode("10OFF");
        order1.printThisOrder();

    }
}
