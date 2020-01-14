package com.java3.eindopdracht;

public class MacOrderSystem {

    public static void main(String[] args) {
      Shop MacEmmen = new Shop();

      //MacEmmen.addDiscountCode("10OFF", "€");
      try {
        MacEmmen.addDiscountCode("HALFTHEPRICE", "50%");
      } catch (Exception e) {
        //asdas
      }
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
    }
}
