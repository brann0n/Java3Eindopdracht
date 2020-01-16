package com.java3.eindopdracht;

import com.java3.eindopdracht.discounts.Discountable;
import com.java3.eindopdracht.menu.*;

import java.util.ArrayList;
import java.util.HashSet;

public class Order {
    private final HashSet<Menu> thisOrder = new HashSet<>();
    public final HashSet<String> dCodes = new HashSet<>();
    public PickUpLocation pickUp;
    private final Shop ContextShop;
    private double discountIsGiven = 0;
    public Order(Shop contextShop) {
        pickUp = new PickUpLocation("Checkout Counter");
        ContextShop = contextShop;
    }

    /**
     * voeg drink toe aan order
     */
    public void addDrink(String drinkName, int amount) {
        if (Drink.checkAllowedDrink(drinkName)) {
            int addCount = 0;
            while (addCount < amount) {
                Drink drinkje = new Drink(drinkName, Drink.getDrinkPrice(drinkName));
                thisOrder.add(drinkje);
                addCount++;
            }
        } else {
            System.out.println("not a drink.");
        }
    }

    /**
     * voeg burger toe
     */
    public void addBurger(String burgerName, int amount) {
        if (Burger.checkAllowedBurger(burgerName)) {
            int addCount = 0;
            while (addCount < amount) {
                Burger burger = new Burger(burgerName, Burger.getBurgerPrice(burgerName));
                thisOrder.add(burger);
                addCount++;
            }
        } else {
            System.out.println("not a burger.");
        }
    }

    /**
     * voeg snack toe
     */
    public void addSnack(String snackName, int amount) {
        if (Snack.checkAllowedSnack(snackName)) {
            int addCount = 0;
            while (addCount < amount) {
                Snack snack = new Snack(snackName, Snack.getSnackPrice(snackName));
                thisOrder.add(snack);
                addCount++;
            }
        } else {
            System.out.println("not a snack.");
        }
    }

    /**
     * voeg special toe
     */
    public void addSpecial(String specialName, int amount) {
        if (Special.checkAllowedSpecial(specialName)) {
            int addCount = 0;
            while (addCount < amount) {
                Special special = new Special(specialName, Special.getSpecialPrice(specialName));
                thisOrder.add(special);
                addCount++;
            }
        } else {
            System.out.println("not a special.");
        }
    }

    /**
     * voeg desert toe aan order
     */
    public void addDesert(String desertName, int amount) {
        if (Desert.checkAllowedDesert(desertName)) {
            int addCount = 0;
            while (addCount < amount) {
                Desert desert = new Desert(desertName, Desert.getDesertPrice(desertName));
                thisOrder.add(desert);
                addCount++;
            }
        } else {
            System.out.println("not a desert.");
        }
    }

    /**
     * deze order wordt uitgeprint
     */
    public void printThisOrder() throws NoProductSelectedException {
        System.out.println("\nThis order contains the following items:");
        for (Menu itemOfMenu : this.thisOrder) {
            System.out.println(itemOfMenu.getItemAndPrice());
        }
        for (String code : dCodes) {
            System.out.println("\nPrice reduction: " + code);
        }
        System.out.println("_________________\nTotal: €" + getTotalPrice() + "\nThis Order can be picked up on location; " + pickUp.getPickUpLocation());
    }

    /**
     * de totaal prijs word berekent ZONDER de discount
     * @return totaalprijs van order zonder discount
     * @throws NoProductSelectedException
     */
    public double getTotalPriceNoDiscounts() throws NoProductSelectedException {
        if (thisOrder.size() != 0) {
            double totalPrice = 0;
            for (Menu menu : thisOrder)
                totalPrice += menu.getPrice();
            return Discountable.round(totalPrice, 2);
        } else {
            throw new NoProductSelectedException("You haven't selected any products to buy.");
        }
    }

    /**
     * de totaal prijs word berekent MET de discount
     * @return totaalprijs van order met discount
     * @throws NoProductSelectedException
     */
    public double getTotalPrice() throws NoProductSelectedException {//totaal prijs word berekent
        double tempPrice = getTotalPriceNoDiscounts();
        for (String code : dCodes) {
            if (ContextShop.discounts.containsString(code)) {
                tempPrice = ContextShop.discounts.get(code).calculateDiscount(tempPrice);
                discountIsGiven = getTotalPriceNoDiscounts() - tempPrice;
            }
        }

        return Discountable.round(tempPrice, 2);
    }

    /**
     * returned de totale discount die gegeven is op deze order
     * @return double gegeven discount op deze order
     */
    public double getDiscountGiven() {
        return discountIsGiven;
    }

    /**
     * set nieuwe pickUp locatie
     * @param location is nieuwe pickUp locatie
     */
    public void setOtherPickUpLocation(String location) {
        pickUp.setDifferentLocation(location);
    }

    /**
     * set een discountcode voor deze order
     * @param dCode word toegevoegd aan lijst met discounts op deze order
     */
    public void addDiscountCode(String dCode) {
        if (ContextShop.discounts.containsString(dCode)) {
            dCodes.add(dCode);
        }
    }

    /**
     * print lijst met allergiën voor elk item in de order
     */
    public void printAllergyInfoPerMenuItem() {
        ArrayList<String> oke = new ArrayList<>();
        for (Menu item : thisOrder) {
            if (!oke.contains(item.getName())) {
                oke.add(item.getName());
                System.out.println(item.getFormattedAllergiesLabel());
            }
        }
    }
}
