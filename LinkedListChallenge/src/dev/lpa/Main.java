package dev.lpa;

import java.util.LinkedList;
import java.util.Scanner;

record TownDistance(String town, int distanceFromSyd) {

    public TownDistance(String town, int distanceFromSyd) {
        this.town = town;
        this.distanceFromSyd = distanceFromSyd;
    }

    @Override
    public String toString() {
        return String.format("%s is %dkm distance from Sydney", town, distanceFromSyd);
    }
}

record Place(String name, int distance){
    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }
}

public class Main {

    public static void main(String[] args) {
        // Call my Solution for testing
        // mySolution();

        // Course solution
        LinkedList<Place> placesToVisit = new LinkedList<>();
        Place adelaide = new Place("Adelaide", 1374);
        addPlace(placesToVisit, adelaide);
        addPlace(placesToVisit, new Place("adelaide", 1374));
        addPlace(placesToVisit, new Place("Brisbane", 917));
        addPlace(placesToVisit, new Place("Perth", 3923));
        addPlace(placesToVisit, new Place("Alice Springs", 2771));
        addPlace(placesToVisit, new Place("Darwin", 3972));
        addPlace(placesToVisit, new Place("Melbourne", 877));

        placesToVisit.addFirst(new Place("Sydney", 0));
        System.out.println(placesToVisit);

        var iterator = placesToVisit.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        printMenu();

        while(!quitLoop){
            if(!iterator.hasPrevious()){
                System.out.println("Originating : " + iterator.next());
                forward = true;
            }
            if(!iterator.hasNext()){
                System.out.println("Final : " + iterator.previous());
                forward = false;
            }
            System.out.println("Enter Value: ");
            String menuItem = scanner.nextLine().toUpperCase().substring(0, 1);

            switch (menuItem) {
                case "F":
                    System.out.println("User wants to go forward");
                    if(!forward) {          // Reversing Direction
                        forward = true;
                        if(iterator.hasNext()){
                            iterator.next();    // Adjust position forward
                        }
                    }
                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    break;

                case "B":
                    System.out.println("User wants to go backward");
                    if(forward) {          // Reversing Direction
                        forward = false;
                        if(iterator.hasPrevious()){
                            iterator.previous();    // Adjust position forward
                        }
                    }
                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                    break;

                case "M":
                    printMenu();
                    break;

                case "L":
                    System.out.println(placesToVisit);
                    break;

                default:
                    quitLoop = true;
                    break;
            }
        }

    }

    private static void addPlace(LinkedList<Place> list, Place place) {
        if(list.contains(place)){
            System.out.println("Found duplicate: " + place);
            return;
        }

        for(Place p : list){
            if(p.name().equalsIgnoreCase(place.name())){
                System.out.println("Found duplicate: " + place);
                return;
            }
        }

        int matchedIndex = 0;
        for(var listplace: list) {
            if(place.distance() < listplace.distance()){
                list.add(matchedIndex, place);
                return;
            }
            matchedIndex++;
        }
        list.add(place);
    }

    private static void printMenu(){

        System.out.println("""
                    Available actions (select word or letter):
                    (F)orward
                    (B)ackward
                    (L)ist Places
                    (M)enu
                    (Q)uit""");
    }

    private static void mySolution(){

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
        while (needSort) {
            needSort = false;
            for (int i = 0; i < placeToVisit.size() - 1; i++) {
                if (placeToVisit.get(i).distanceFromSyd() > placeToVisit.get(i + 1).distanceFromSyd()) {
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


        var iterator = placeToVisit.listIterator();
        boolean quitMenu = false;

        // Get user input
        Scanner scanner = new Scanner(System.in);

        while (!quitMenu) {
            System.out.println("""
                    Available actions (select word or letter):
                    (F)orward
                    (B)ackward
                    (L)ist Places
                    (M)enu
                    (Q)uit""");

            String userInput = scanner.nextLine().toUpperCase();

            switch (userInput.charAt(0)) {
                case 'F' -> {
                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                        scanner.nextLine();
                    } else {
                        System.out.println("Already in the last place, no next place is found.");
                        scanner.nextLine();
                    }
                    quitMenu = false;
                }
                case 'B' -> {
                    // Check if in the first place
                    if (placeToVisit.listIterator().hasPrevious()) {
                        System.out.println(iterator.previous());
                        scanner.nextLine();

                    } else {
                        System.out.println("Already in the first place, no previous place is found.");
                        scanner.nextLine();
                    }
                    quitMenu = false;
                }
                case 'L' -> {
                    if (iterator.hasPrevious()){
                        iterator.previous();
                        System.out.println(iterator.next());
                        scanner.nextLine();
                    } else {
                        System.out.println(iterator.next());
                        iterator.previous();
                        scanner.nextLine();
                    }
                    quitMenu = false;
                }
                case 'M' -> {
                    quitMenu = false;
                }
                case 'Q' -> {
                    quitMenu = true;
                }
                default -> {
                    System.out.println("Invalid input");
                    scanner.nextLine();
                    quitMenu = false;
                }
            }
        }
    }
}

