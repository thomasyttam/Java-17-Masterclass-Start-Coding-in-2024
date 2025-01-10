package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animal.move();
//        flier.move();
//        tracked.move();

//        flier.takeOff();
//        flier.fly();
//        tracked.track();
//        flier.land();
//        All birds below
//        System.out.println(animal.getClass().getSimpleName());
//        System.out.println(flier.getClass().getSimpleName());
//        System.out.println(tracked.getClass().getSimpleName());

        inFlight(flier);
        inFlight(new Jet());
        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;

        System.out.printf("The truck traveled %.2f km or %.2f miles%n",
                kmsTraveled, milesTraveled);

        ArrayList<FlightEnabled> fliers = new ArrayList<>();    // instance type, ArrayList implement List interface
        fliers.add(bird);

        List<FlightEnabled> betterfliers = new ArrayList<>();   // List is interface type
        betterfliers.add(bird);

        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

        triggerFliers(betterfliers);
        flyFliers(betterfliers);
        landFliers(betterfliers);
    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        if(flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

//    private static void triggerFliers(ArrayList<FlightEnabled> fliers) { // Change to interface
    private static void triggerFliers(List<FlightEnabled> fliers) {

        for(var flier : fliers) {
            flier.takeOff();
        }
    }

//    private static void flyFliers(ArrayList<FlightEnabled> fliers) { // Change to interface
    private static void flyFliers(List<FlightEnabled> fliers) {

        for(var flier : fliers) {
            flier.fly();
        }
    }

//    private static void landFliers(ArrayList<FlightEnabled> fliers) { // Change to interface
    private static void landFliers(List<FlightEnabled> fliers) {

        for(var flier : fliers) {
            flier.land();
        }
    }
}
