package com.java3.eindopdracht.discounts;

import java.util.HashSet;

public class DiscountHashSet<T extends Discountable> extends HashSet<T> {

    public boolean containsString(String name) {
        for (T item : this) {
            if (item.getThisDiscountCode().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches the current HashSet for the specified item and then returns it
     * Said item type must extend Discountable
     *
     * @param name the name of the item you are searching for
     * @return returns the full object
     */
    public T get(String name) {
        for (T item : this) {
            if (item.getThisDiscountCode().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
