package dev.lpa;

interface FlightEnabled {

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
