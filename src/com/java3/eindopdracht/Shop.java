package com.java3.eindopdracht;

import com.java3.eindopdracht.discounts.DiscountHashSet;
import com.java3.eindopdracht.discounts.Discountable;

import java.util.HashSet;

public class Shop {
    private final HashSet<Order> orderList = new HashSet<>();
    public final DiscountHashSet<Discountable> discounts = new DiscountHashSet<>();
    private double RevenueOfToday;

    public Shop() {
        //discounts.add(new Percentage("Percentage" , 5));
        // discounts.add(new Percentage("Tientie", 10));
        // discounts.add(new Percentage("Lekker", 15));
        // discounts.add(new Percentage("DikkeBMW", 20));

        //discounts.add(new Price("funf", 5));
        //discounts.add(new Price("zehn", 10));
        //discounts.add(new Price("funfzehn", 15));
        //discounts.add(new Price("zwanzig", 20));
    }

    public Order createOrder() {
        return new Order(this);
    }

    public void placeOrder(Order order) {//toevoegen van een order bij deze winkel
        orderList.add(order);
    }

    public void printAllOrders() {//alle orders worden geprint met de bestelde items en prijzen
        orderList.forEach(Order::printThisOrder);
    }

    public void printRevenue() {//print de omzet van de dag
        RevenueOfToday = 0;
        orderList.forEach((i) -> {
            RevenueOfToday += i.getTotalPrice();
        });
        System.out.println("\nThe Total Revenue of Today is: €" + RevenueOfToday);
        //TODO: add info about revenue with and without all discounts
    }

    public void printDiscountList() {// print een lijst met alle discount codes en hoeveelheid
        System.out.println("Available discount codes: ");
        for (Discountable discount : discounts) {
            System.out.println(discount.toString());
        }
    }

    public void addDiscountCode(String code, String discount) {
        //voeg een nieuwe kortings code toe, als het geen percentage is dan is het gwn vlak 5 geld ofzo
        //AI stuff:
        if (discount.startsWith("€")) {
            int dPrice = Integer.parseInt(discount.substring(1, 3)); //take only the first 2 characters after the euro sign, 99 will be max :)
            discounts.add(new Price(code, dPrice));
        } else if (discount.endsWith("%")) {
            int dPercentage = Integer.parseInt(discount.substring(0, 2)); //take only the first 2 characters of the string max percentage will be 99 :)
            discounts.add(new Percentage(code, dPercentage));
        } else {
            //oof
            //TODO: decide what to do here
        }
    }

    public void deleteFromDiscountList(String code) {// verwijderen uit korting lijst
        discounts.removeIf(d -> d.getName() == code);
    }
}
