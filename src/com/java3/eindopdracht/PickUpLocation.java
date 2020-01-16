package com.java3.eindopdracht;

public class PickUpLocation {
    private String location;

    public PickUpLocation(String location) {//anders kun je een pickuploction aangeven zonder dat je een locatie hebt
        this.location = location;
    }

    /**
     * nieuwe pickUp locatie word geset
     * @param location is nieuwe pickUp loactie
     */
    public void setDifferentLocation(String location) {//veranderen van pick up locatie
        this.location = location;
    }

    /**
     * returned de pickUp locatie
     * @return locatie
     */
    public String getPickUpLocation() {
        return this.location;
    }
}
