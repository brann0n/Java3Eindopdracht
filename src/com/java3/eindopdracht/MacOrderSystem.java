package com.java3.eindopdracht;

public class MacOrderSystem {

    public static void main(String[] args){
        Shop MacEmmen = new Shop();
        MacEmmen.addDiscountCode("Percentage", "Testing", 10);//nieuwe kortins code
        MacEmmen.addDiscountCode("Wat anders", "Oof", 5);
        MacEmmen.deleteFromDiscountList("zwanzig");//oude code weg

        Order MyOrder = new Order();//order1
        MyOrder.addDrink("Milkshake", 3.50);
        MyOrder.addBurger("Big Mac", 6.50);
        MyOrder.addSnack("Euroknaller", 1.00);
        MyOrder.addSpecial("Patat klein", 1.50);
        MyOrder.addDesert("Frozen Banana", 3.50);
        MyOrder.setOtherPickUpLocation("Behind the creepy clown statue");
        MyOrder.setDiscountcode("Tientie");

        Order notMyOrder = new Order();//order2
        notMyOrder.addDrink("Sinas", 0.50);
        notMyOrder.addBurger("Big Tasty", 12.50);
        notMyOrder.addSnack("McKroket", 1.80);
        notMyOrder.addSpecial("Patat groot", 4.50);
        notMyOrder.addDesert("Sundae", 6.90);

        Order anotherOrder = new Order();//order3
        anotherOrder.addSpecial("Patat groot", 4.50);
        anotherOrder.addDesert("Sundae", 6.90);
        anotherOrder.addDesert("Sundae", 6.90);

        MacEmmen.placeOrder(MyOrder);//orders plaatsen
        MacEmmen.placeOrder(notMyOrder);
        MacEmmen.placeOrder(anotherOrder);

        //vanaf hier word er iets geprint
        MacEmmen.getDicountList();//kortingslijst word geprint
        MyOrder.getAllergList();//allergiën lijst word geprint
        MacEmmen.printAllOrders();//alle order uitprinten
        MacEmmen.printRevenue();//omzet uitprinten

    }
}
