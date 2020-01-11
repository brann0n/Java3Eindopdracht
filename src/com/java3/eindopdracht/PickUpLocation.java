package com.java3.eindopdracht;

public class PickUpLocation {
    private String location;

    public PickUpLocation(String location) {//anders kun je een pickuploction aangeven zonder dat je een locatie hebt
        this.location = location;
    }

    public void setDifferentLocation(String location) {//veranderen van pick up locatie
        this.location = location;
    }

    public String getPickUpLocation() {
        return this.location;
    }
}
