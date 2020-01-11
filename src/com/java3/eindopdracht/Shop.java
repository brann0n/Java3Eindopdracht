package com.java3.eindopdracht;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Shop {
    HashSet<Order> orderList = new HashSet<>();
    private double RevenueOfToday;
    private HashMap<String, Integer> discountCodesPercentage = new HashMap<>();
    private HashMap<String, Integer> discountCodesFlat = new HashMap<>();

    public Shop() {
        discountCodesPercentage.put("Percentage", 5);
        discountCodesPercentage.put("Tientie", 10);
        discountCodesPercentage.put("Lekker", 15);
        discountCodesPercentage.put("DikkeBMW", 20);

        discountCodesFlat.put("funf", 5);
        discountCodesFlat.put("zehn", 10);
        discountCodesFlat.put("funfzehn", 15);
        discountCodesFlat.put("zwanzig", 20);
    }

    public void placeOrder(Order order) {//toevoegen van een order bij deze winkel
        orderList.add(order);
    }

    public void printAllOrders() {//alle orders worden geprint met de bestelde items en prijzen

        orderList.forEach((i) -> {
            i.printThisOrder();
        });
    }

    public void printRevenue() {//print de omzet van de dag
        RevenueOfToday = 0;
        orderList.forEach((i) -> {
            RevenueOfToday += i.getTotalPrice();
        });
        System.out.println("\nThe Total Revenue of Today is: €" + RevenueOfToday);
    }

    public void getDicountList() {// print een lijst met alle discount codes en hoeveelheid
        System.out.println("Percentage discountCodes:");
        for (Map.Entry<String, Integer> entry : discountCodesPercentage.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value + "%");
        }

        System.out.println("\nFlat Money discountCodes:");
        for (Map.Entry<String, Integer> entry : discountCodesFlat.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : €" + value);
        }
    }

    public void addDiscountCode(String option, String code, int disc) {//voeg een nieuwe kortings code toe, als het geen percentage is dan is het gwn vlak 5 geld ofzo
        if ("Percentage".equals(option) && disc < 100) {
            discountCodesPercentage.put(code, disc);
        } else {
            discountCodesFlat.put(code, disc);
        }
    }

    public void deleteFromDiscountList(String code) {// verwijderen uit korting lijst
        for (Map.Entry<String, Integer> entry : discountCodesPercentage.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (code.equals(key)) {
                discountCodesPercentage.remove(key, value);
            }
        }
        for (Map.Entry<String, Integer> entry : discountCodesFlat.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (code.equals(key)) {
                discountCodesFlat.remove(key, value);
            }
        }
    }
}
