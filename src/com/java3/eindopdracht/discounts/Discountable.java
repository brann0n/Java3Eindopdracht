package com.java3.eindopdracht.discounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Discountable {
    String getName();

    double calculateDiscount(double totalPrice);

    /**
     * Custom function to round the big doubles for prices
     *
     * @param value  The number to round
     * @param places The amount of decimals to round to
     * @return The rounded number
     */
    static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
