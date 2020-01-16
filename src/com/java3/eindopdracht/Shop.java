package com.java3.eindopdracht;

import com.java3.eindopdracht.discounts.DiscountHashSet;
import com.java3.eindopdracht.discounts.Discountable;

import java.util.HashSet;

public class Shop {
    public final HashSet<Order> orderList = new HashSet<>();
    public final DiscountHashSet<Discountable> discounts = new DiscountHashSet<>();

    public Shop() {
    }

    /**
     * een order word hier aangemaakt en gereturned
     * @return Order
     */
    public Order createOrder() {
        Order newOrder = new Order(this);
        this.placeOrder(newOrder);
        return newOrder;
    }

    /**
     * voeg order toe aan lijst met orders
     * @param order
     */
    public void placeOrder(Order order) {//toevoegen van een order bij deze winkel
        orderList.add(order);
    }

    /**
     * lijst met alle orders in de shop wordt geprint
     * @throws NoProductSelectedException
     */
    public void printAllOrders() throws NoProductSelectedException {//alle orders worden geprint met de bestelde items en prijzen
        for (Order order : orderList) {
            order.printThisOrder();
        }
    }

    /**
     * de totale omzet word geprint, hierbij word ook de totaal gegeven korting weergegeven
     */
    public void printRevenue() {
        double revenueOfToday = 0;
        double discountOfToday = 0;

        for (Order itemOfOrder : orderList) {
            try {
                revenueOfToday += itemOfOrder.getTotalPrice();
                discountOfToday += itemOfOrder.getDiscountGiven();
            } catch (NoProductSelectedException e) {
                //this order has no products, ignore it for the total revenue
            }
        }

        System.out.println("\nThe Total Revenue of Today is: €" + revenueOfToday + "\nDiscount given today is: €" + discountOfToday);
    }

    /**
     * print lijst van alle discount codes met hoeveelheid korting
     */
    public void printDiscountList() {// print een lijst met alle discount codes en hoeveelheid
        System.out.println("Available discount codes: ");
        for (Discountable discount : discounts) {
            System.out.println(discount.toString());
        }
    }

    /**
     * kortingscode wordt toegevoegd aan discount list
     * @param code code voor discount
     * @param discount hoeveelheid discount dat word gegeven
     * @throws Exception
     */
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

    /**
     * code word verwijderd uit lijst van discounts
     * @param code deze code wordt verwijderd
     */
    public void deleteFromDiscountList(String code) {// verwijderen uit korting lijst
        discounts.removeIf(d -> d.getThisDiscountCode() == code);
    }
}
