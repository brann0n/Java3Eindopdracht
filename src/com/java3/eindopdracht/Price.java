package com.java3.eindopdracht;

import com.java3.eindopdracht.discounts.Discountable;

public class Price implements Discountable {

    private final String thisDiscountCode;
    private final int Discount;

    public Price(String thisDiscountCode, int discount) {
        this.thisDiscountCode = thisDiscountCode;
        Discount = discount;
    }

    /**
     * the discount code
     * @return String discountcode
     */
    @Override
    public String getThisDiscountCode() {
        return thisDiscountCode;
    }

    /**
     * returned een nieuwe prijs (de totaal prijs - de discount)
     * @param totalPrice hier gaat de discount af
     * @return nieuwe prijs
     */
    @Override
    public double calculateDiscount(double totalPrice) {
        //first check if the discount is not bigger than the totalPrice
        if (Discount >= totalPrice) {
            return 0;
        } else {
            return totalPrice - Discount;
        }
    }

    /**
     * returned een String met discountcode en hoeveel € discount
     * @return String
     */
    @Override
    public String toString() {
        return thisDiscountCode + ": €" + Discount;
    }
}
