package com.java3.eindopdracht.allergie;

public enum AllergieType {
    /**
    * All the possible allergies in a list
    */
    CELERY_AND_CELERIAC("Celery and Celeriac"),
    CRUSTACEANS("Crustaceans"),
    EGG("Egg"),
    FISH("Fish"),
    GLUTEN("Gluten"),
    LUPIN("Lupin"),
    MILK("Milk"),
    MOLLUSKS("Mollusks"),
    MUSTARD("Mustard"),
    NUTS("Nuts"),
    PEANUT("Peanut"),
    SESAME("Sesame"),
    SOYA("Soya"),
    SULPHUR_DIOXIDE_AND_SULPHIDES("Sulphur Dioxide and Sulphides (levels greater than 10ppm)");

    private final String value;

    AllergieType(String name) {
        value = name;
    }

    @Override
    public String toString() {
        return value;
    }
}
