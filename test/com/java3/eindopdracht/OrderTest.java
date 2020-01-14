package com.java3.eindopdracht;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    Shop MacEmmen;
    Order order1;
    @BeforeEach
    void setUp() {
        MacEmmen = new Shop();
        order1 = MacEmmen.createOrder();
        MacEmmen.placeOrder(order1);

       /* Shop MacEmmen = new Shop();

        MacEmmen.addDiscountCode("10OFF", "€10");
        MacEmmen.addDiscountCode("HALFTHEPRICE", "50%");
        MacEmmen.printDiscountList();

        Order order1 = MacEmmen.createOrder();
        MacEmmen.placeOrder(order1);

        order1.addBurger("Big Tasty", 2);
        order1.addBurger("Big Mac", 2);
        order1.addDrink("Sinas", 4);
        order1.addDiscountCode("HALFTHEPRICE");
        order1.addDiscountCode("10OFF");
        order1.printThisOrder();
        order1.printAllergyInfoPerMenuItem();


        Order order2 = MacEmmen.createOrder();
        MacEmmen.placeOrder(order2);

        order2.addBurger("XXL Meat Burger", 2);
        order2.addDrink("Milkshake", 4);
        order2.addDiscountCode("10OFF");
        order2.printThisOrder();
        order2.printAllergyInfoPerMenuItem();

        //MacEmmen.printAllOrders();
        MacEmmen.printRevenue();
        */

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addDrink() {

    }

    @Test
    void addBurger() {
    }

    @Test
    void addSnack() {
    }

    @Test
    void addSpecial() {
    }

    @Test
    void addDesert() {
    }

    @Test
    void getTotalPriceNoDiscounts() {
    }

    @Test
    void getTotalPrice() {
    }

    @Test
    void setOtherPickUpLocation() {
        Shop MacEmmen = new Shop();

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
}