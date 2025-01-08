package dev.lpa;

interface FlightEnabled {

    public static final double MILES_TO_KM = 1.60934;   // public, static, final are redundant
    double KM_TO_MILES = 0.621371;

    public abstract void takeOff(); // public and abstract modifiers are redundant,
                                    // meaning unnecessary to declare
    abstract void land();           // abstract modifier is redundant, meaning
                                    // unnecessary to declare
    void fly();                     // This is PREFERRED declaration, public and
                                    // abstract are implied
}

interface Trackable {

    void track();
}


public abstract class Animal {

    public abstract void move();
}
