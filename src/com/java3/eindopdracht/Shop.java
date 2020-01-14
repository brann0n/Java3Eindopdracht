package com.java3.eindopdracht;

import com.java3.eindopdracht.discounts.DiscountHashSet;
import com.java3.eindopdracht.discounts.Discountable;

import java.util.HashSet;

public class Shop {
    public final HashSet<Order> orderList = new HashSet<>();
    public final DiscountHashSet<Discountable> discounts = new DiscountHashSet<>();
    private double RevenueOfToday;
    private double discountOfToday;

    public Shop() {
    }

    public Order createOrder() {
        Order newOrder = new Order(this);
        this.placeOrder(newOrder);
        return newOrder;
    }

    public void placeOrder(Order order) {//toevoegen van een order bij deze winkel
        orderList.add(order);
    }

    public void printAllOrders() throws NoProductSelectedException {//alle orders worden geprint met de bestelde items en prijzen
        for (Order order : orderList) {
            order.printThisOrder();
        }
    }

    public void printRevenue() {//print de omzet van de dag
        RevenueOfToday = 0;
        discountOfToday = 0;
        orderList.forEach((i) -> {
            try {
                RevenueOfToday += i.getTotalPrice();
                discountOfToday += i.getDiscountGiven();
            } catch (NoProductSelectedException e) {
                //this order has no products, ignore it for the total revenue
            }
        });
        System.out.println("\nThe Total Revenue of Today is: €" + RevenueOfToday + "\nDiscount given today is: €" + discountOfToday);
    }

    public void printDiscountList() {// print een lijst met alle discount codes en hoeveelheid
        System.out.println("Available discount codes: ");
        for (Discountable discount : discounts) {
            System.out.println(discount.toString());
        }
    }

    public void addDiscountCode(String code, String discount) throws Exception {
        //voeg een nieuwe kortings code toe, als het geen percentage is dan is het gwn vlak 5 geld ofzo
        //AI stuff:
        if (discount.startsWith("€")) {
            try {
                int dPrice = Integer.parseInt(discount.replace("€", "")); //take only the first 2 characters after the euro sign, 99 will be max :)
                discounts.add(new Price(code, dPrice));
            } catch (Exception e) {
                System.out.println("Incorrect discount euro value submitted.");
            }
        } else if (discount.endsWith("%")) {
            try {
                int dPercentage = Integer.parseInt(discount.replace("%", "")); //take only the first 2 characters of the string max percentage will be 99 :)
                discounts.add(new Percentage(code, dPercentage));
            } catch (Exception e) {
                System.out.println("Incorrect discount percentage value submitted.");
            }
        } else {
            throw new Exception("Unknown discount value submitted");
            // System.out.println("Incorrect discount value submitted.");
        }
    }

    public void deleteFromDiscountList(String code) {// verwijderen uit korting lijst
        discounts.removeIf(d -> d.getName() == code);
    }
}
