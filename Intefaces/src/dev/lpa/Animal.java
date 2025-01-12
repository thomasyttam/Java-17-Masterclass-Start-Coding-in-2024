package dev.lpa;

enum FlightStages implements Trackable {GROUND, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {

        if (this != GROUND){
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStage() {
        FlightStages[] allStages = values();
        return  allStages[(ordinal() + 1) % allStages.length];
    }
}

record DragonFly(String name, String type) implements FlightEnabled {

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

class Satellite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUND;

    public void achieveOrbit() {
        transition("Orbit achieved!");
    };

    @Override
    public void takeOff() {

        transition("Taking Off");
    }

    @Override
    public void land() {

        transition("Landing");
    }

    @Override
    public void fly() {

        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    public void transition (String description) {

        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}
interface OrbitEarth extends FlightEnabled {

    void achieveOrbit();

    private static void log(String description) {

        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description) {

        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {

        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning Transition to " + nextStage);
        return nextStage;
    }
}

interface FlightEnabled {

    public static final double MILES_TO_KM = 1.60934;   // public, static, final are redundant
    double KM_TO_MILES = 0.621371;

    public abstract void takeOff(); // public and abstract modifiers are redundant,
                                    // meaning unnecessary to declare
    abstract void land();           // abstract modifier is redundant, meaning
                                    // unnecessary to declare
    void fly();                     // This is PREFERRED declaration, public and
                                    // abstract are implied
//    FlightStages transition(FlightStages stage);

    default FlightStages transition(FlightStages stage) {
//        System.out.println("transition not implemented on " + getClass().getSimpleName());
//        return null;
        FlightStages nexStage = stage.getNextStage();
        System.out.println("Transition from " + stage + " to " + nexStage);
        return nexStage;
    }
}

interface Trackable {

    void track();
}


public abstract class Animal {

    public abstract void move();
}
