package com.java3.eindopdracht;

import org.junit.jupiter.api.AfterEach;
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
        //set up the discountcodes for the shop
        try {
            MacEmmen.addDiscountCode("10OFF", "€10");
            MacEmmen.addDiscountCode("HALFTHEPRICE", "50%");
        } catch (Exception e) {
            //yeet
        }
       /* Shop MacEmmen = new Shop();

        MacEmmen.addDiscountCode("10OFF", "€10");
        MacEmmen.addDiscountCode("HALFTHEPRICE", "50%");
        MacEmmen.printDiscountList();
        oke

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
        // Sinas costs €2, so total price should be 8 when added
        order1.addDrink("Sinas", 4);
        assertEquals(8,order1.getTotalPrice());

        // Diet Coke is not available in this shop(not a drink)
        order1.addDrink("Diet Coke", 2);
        assertEquals(8,order1.getTotalPrice());

        // Sinas but its 0, nothing should be added
        order1.addDrink("Sinas", 0);
        assertEquals(8,order1.getTotalPrice());

        // Sinas but its a negative amount, nothing should be added
        order1.addDrink("Sinas", -1);
        assertEquals(8,order1.getTotalPrice());
    }

    @Test
    void addBurger() {
        // Big Mac costs €6.50, so total price should be 26 when added
        order1.addBurger("Big Mac", 4);
        assertEquals(26,order1.getTotalPrice());

        // add XXL Meat Burger (costs €10), so total price should be 66 when added
        order1.addBurger("XXL Meat Burger", 4);
        assertEquals(66,order1.getTotalPrice());

        //Mac Cheese is not available in this shop(not a burger)
        order1.addBurger("Mac Cheese", 2);
        assertEquals(66,order1.getTotalPrice());

        // Big Mac but its 0, nothing should be added
        order1.addBurger("Big Mac", 0);
        assertEquals(66,order1.getTotalPrice());

        // Big Mac but its a negative amount, nothing should be added
        order1.addBurger("Big Mac", -1);
        assertEquals(66,order1.getTotalPrice());
    }

    @Test
    void addSnack() {
        // Euroknaller costs €1.50, so total price should be 26 when added
        order1.addSnack("Euroknaller", 6);
        assertEquals(6,order1.getTotalPrice());

        // add 10 Chicken Nuggets (costs €5), so total price should be 66 when added
        order1.addSnack("10 Chicken Nuggets", 2);
        assertEquals(16,order1.getTotalPrice());

        //Mac Cheese is not available in this shop(not a snack)
        order1.addSnack("Mac Cheese", 2);
        assertEquals(16,order1.getTotalPrice());

        // Euroknaller but its 0, nothing should be added
        order1.addSnack("Euroknaller", 0);
        assertEquals(16,order1.getTotalPrice());

        // Euroknaller but its a negative amount, nothing should be added
        order1.addSnack("Euroknaller", -1);
        assertEquals(16,order1.getTotalPrice());
    }

    @Test
    void addSpecial() {
        // KinderMenu costs €10, so total price should be 26 when added
        order1.addSpecial("KinderMenu", 6);
        assertEquals(60,order1.getTotalPrice());

        // add Patat groot (costs €3), so total price should be 66 when added
        order1.addSpecial("Patat groot", 2);
        assertEquals(66,order1.getTotalPrice());

        //Mac Cheese is not available in this shop(not a special)
        order1.addSpecial("Mac Cheese", 2);
        assertEquals(66,order1.getTotalPrice());

        // KinderMenu but its 0, nothing should be added
        order1.addSpecial("KinderMenu", 0);
        assertEquals(66,order1.getTotalPrice());

        // KinderMenu but its a negative amount, nothing should be added
        order1.addSpecial("KinderMenu", -1);
        assertEquals(66,order1.getTotalPrice());
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

        //set up the discountcodes for the shop
        MacEmmen.addDiscountCode("10OFF", "€10");
        MacEmmen.addDiscountCode("HALFTHEPRICE", "50%");
        assertEquals(2,MacEmmen.discounts.size());

        //now with wrong inputasd
        order1.addDiscountCode("HALFTHEPRICE");
        order1.addDiscountCode("10OFF");
        assertEquals(2,MacEmmen.discounts.size());
    }
}