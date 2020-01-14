package com.java3.eindopdracht;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    Shop MacEmmen;
    Order order1;
    PickUpLocation pickUp;
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
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addDrink() throws NoProductSelectedException {
        // Sinas costs €2, so total price should be 8 when added
        order1.addDrink("Sinas", 4);
        assertEquals(8, order1.getTotalPrice());

        // Diet Coke is not available in this shop(not a drink)
        order1.addDrink("Diet Coke", 2);
        assertEquals(8, order1.getTotalPrice());

        // Sinas but its 0, nothing should be added
        order1.addDrink("Sinas", 0);
        assertEquals(8,order1.getTotalPrice());

        // Sinas but its a negative amount, nothing should be added
        order1.addDrink("Sinas", -1);
        assertEquals(8,order1.getTotalPrice());
    }

    @Test
    void addBurger() throws NoProductSelectedException {
        // Big Mac costs €6.50, so total price should be 26 when added
        order1.addBurger("Big Mac", 4);
        assertEquals(26, order1.getTotalPrice());

        // add XXL Meat Burger (costs €10), so total price should be 66 when added
        order1.addBurger("XXL Meat Burger", 4);
        assertEquals(66, order1.getTotalPrice());

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
    void addSnack() throws NoProductSelectedException {
        // Euroknaller costs €1.50, so total price should be 6 when added
        order1.addSnack("Euroknaller", 6);
        assertEquals(6, order1.getTotalPrice());

        // add 10 Chicken Nuggets (costs €5), so total price should be 66 when added
        order1.addSnack("10 Chicken Nuggets", 2);
        assertEquals(16, order1.getTotalPrice());

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
    void addSpecial() throws NoProductSelectedException {
        // KinderMenu costs €10, so total price should be 60 when added
        order1.addSpecial("KinderMenu", 6);
        assertEquals(60, order1.getTotalPrice());

        // add Patat groot (costs €3), so total price should be 66 when added
        order1.addSpecial("Patat groot", 2);
        assertEquals(66, order1.getTotalPrice());

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
    void addDesert() throws NoProductSelectedException {
        // Waterijsje costs €0.9, so total price should be 26 when added
        order1.addDesert("Waterijsje", 2);
        assertEquals(1.8, order1.getTotalPrice());

        // add Sundae (costs €1.4), so total price should be 66 when added
        order1.addDesert("Sundae", 2);
        assertEquals(4.6, order1.getTotalPrice());

        //Mac Cheese is not available in this shop(not a special)
        order1.addDesert("Mac Cheese", 2);
        assertEquals(4.6,order1.getTotalPrice());

        // Waterijsje but its 0, nothing should be added
        order1.addDesert("Waterijsje", 0);
        assertEquals(4.6,order1.getTotalPrice());

        // Waterijsje but its a negative amount, nothing should be added
        order1.addDesert("Waterijsje", -1);
        assertEquals(4.6,order1.getTotalPrice());
    }

    @Test
    void getTotalPriceNoDiscounts() throws NoProductSelectedException {
        // Waterijsje costs €0.9, so total price should be 20 when added
        order1.addDesert("Waterijsje", 20);
        assertEquals(18,order1.getTotalPriceNoDiscounts());
    }

    @Test
    void getTotalPrice() throws NoProductSelectedException {
        // Waterijsje costs €0.9, so total price should be 20 when added
        order1.addDesert("Waterijsje", 20);
        order1.addDesert("Waterijsje", 20);
        assertEquals(36,order1.getTotalPrice());
    }

    @Test
    void setOtherPickUpLocation() {

        assertEquals("Checkout Counter",  order1.pickUp.getPickUpLocation());
        order1.setOtherPickUpLocation("Outside Counter");
        assertEquals("Outside Counter",  order1.pickUp.getPickUpLocation());
    }

    @Test
    void addDiscountCode() {
        //with correct input
        order1.addDiscountCode("HALFTHEPRICE");
        order1.addDiscountCode("10OFF");
        assertEquals(2,order1.dCodes.size());

        //with wrong discount codes should do nothing
        order1.addDiscountCode("NOTACODE");
        order1.addDiscountCode("NOTADISCOUNT");
        order1.addDiscountCode("");
        assertEquals(2,order1.dCodes.size());


    }
}