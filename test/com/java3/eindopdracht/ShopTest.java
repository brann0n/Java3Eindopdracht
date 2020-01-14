package com.java3.eindopdracht;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopTest {
        Shop shop = new Shop();

    @Test
    void createOrder() {
        shop.createOrder();
        assertEquals(1, shop.orderList.size());
    }

}