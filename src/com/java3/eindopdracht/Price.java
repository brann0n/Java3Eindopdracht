package com.java3.eindopdracht;

import com.java3.eindopdracht.discounts.Discountable;

public class Price implements Discountable {

    private final String Name;
    private final int Discount;

    public Price(String name, int discount) {
        Name = name;
        Discount = discount;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public double calculateDiscount(double totalPrice) {
        //first check if the discount is not bigger than the totalPrice
        if (Discount >= totalPrice) {
            return 0;
        } else {
            return totalPrice - Discount;
        }
    }

    @Override
    public String toString() {
        return Name + ": €" + Discount;
    }
}
