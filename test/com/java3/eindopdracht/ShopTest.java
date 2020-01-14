package com.java3.eindopdracht;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createOrder() {
    }

    @Test
    void placeOrder() {
    }

    @Test
    void addDiscountCode() {
        Shop MacEmmen = new Shop();

        //with correct input
        MacEmmen.addDiscountCode("10OFF", "€10");
        MacEmmen.addDiscountCode("HALFTHEPRICE", "50%");
        assertEquals(2,MacEmmen.discounts.size());

        //now with wrong input
        MacEmmen.addDiscountCode("TEST", "50");
        MacEmmen.addDiscountCode("TEST", "€");
        MacEmmen.addDiscountCode("TEST", "%");
        MacEmmen.addDiscountCode("TEST", "");
        assertEquals(2,MacEmmen.discounts.size());
    }

    @Test
    void deleteFromDiscountList() {
    }
}