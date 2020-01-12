package com.java3.eindopdracht;

import com.java3.eindopdracht.discounts.Discountable;

public class Percentage implements Discountable {

    private final String Name;
    private final int Discount;

    public Percentage(String name, int discount) {
        Name = name;
        Discount = discount;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public double calculateDiscount(double totalPrice) {
        //first turn the percentage into a factor:
        double factor = Discount / 100d;
        //now return the price * the factor
        return totalPrice * factor;
    }

    @Override
    public String toString() {
        return Name + ": " + Discount + "%";
    }
}
