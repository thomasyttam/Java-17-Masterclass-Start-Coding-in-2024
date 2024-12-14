package dev.lpa;

import java.util.LinkedList;

record TownDistance(String town, int distanceFromSyd) {

    public TownDistance(String town, int distanceFromSyd){
        this.town = town;
        this.distanceFromSyd = distanceFromSyd;
    }

    @Override
    public String toString(){
        return String.format("%s is %dkm distance from Sydney", town, distanceFromSyd);
    }
}

public class Main {

    public static void main(String[] args) {
        LinkedList<TownDistance> placeToVisit = new LinkedList<>();

        placeToVisit.add(new TownDistance("Sydney", 0));
        placeToVisit.add(new TownDistance("Adelaide", 1374));
        placeToVisit.add(new TownDistance("Alice Springs", 2771));
        placeToVisit.add(new TownDistance("Brisbane", 917));
        placeToVisit.add(new TownDistance("Darwin", 3972));
        placeToVisit.add(new TownDistance("Melbourne", 877));
        placeToVisit.add(new TownDistance("Perth", 3923));

    }
}
