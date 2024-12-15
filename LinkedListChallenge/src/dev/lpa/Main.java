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

        for (var place : placeToVisit) {
            System.out.println(place);
        }

        // Sort the linked list
        boolean needSort = true;
        while(needSort){
            needSort = false;
            for (int i = 0; i < placeToVisit.size() - 1; i++) {
                if(placeToVisit.get(i).distanceFromSyd() > placeToVisit.get(i + 1).distanceFromSyd()){
                    TownDistance tempTown = placeToVisit.get(i);
                    placeToVisit.set(i, placeToVisit.get(i + 1));
                    placeToVisit.set(i + 1, tempTown);
                    needSort = true;
                }
            }
        }

        for (var place : placeToVisit) {
            System.out.println(place);
        }

        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit""");

    }
}
