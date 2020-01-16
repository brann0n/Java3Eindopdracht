package com.java3.eindopdracht;

import com.java3.eindopdracht.discounts.Discountable;

public class Percentage implements Discountable {

    private final String thisDiscountCode;
    private final int Discount;

    public Percentage(String thisDiscountCode, int discount) {
        this.thisDiscountCode = thisDiscountCode;
        Discount = discount;
    }

    /**
     * returned naam van de percentage discount code
     * @return dicountcode
     */
    @Override
    public String getThisDiscountCode() {
        return thisDiscountCode;
    }

    /**
     * de nieuwe prijs van een item word berekent
     * @param totalPrice wordt berekent naar nieuwe prijs
     * @return nieuwe prijs (met korting er af)
     */
    @Override
    public double calculateDiscount(double totalPrice) {
        //first turn the percentage into a factor:
        double factor = Discount / 100d;
        //now return the price * the factor
        return totalPrice * factor;
    }

    /**
     * returned een string met de dicountcode en het percentage korting
     * @return String
     */
    @Override
    public String toString() {
        return thisDiscountCode + ": " + Discount + "%";
    }
}
