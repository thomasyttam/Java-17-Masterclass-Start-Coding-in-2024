package dev.lpa;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        // LinkedList<String> placeToVisit = new LinkedList<>();
        var placeToVisit = new LinkedList<String>();

        placeToVisit.add("Sydney");
        placeToVisit.add(0,"Canberra");
        System.out.println(placeToVisit);

        addMoreElements(placeToVisit);
        System.out.println(placeToVisit);

//        removeElements(placeToVisit);
//        System.out.println(placeToVisit);

//        gettingElements(placeToVisit);

        printItinerary(placeToVisit);
        printItinerary2(placeToVisit);
        printItinerary3(placeToVisit);

        var placeToVisit2 = new LinkedList<>(placeToVisit);

        System.out.println(placeToVisit); // iterator
        testIterator(placeToVisit);

        System.out.println(placeToVisit2); // listIterator
        testIterator2(placeToVisit2);
    }

    private static void addMoreElements(LinkedList<String> list){
        list.addFirst("Darwin");
        list.addLast("Hobart");
        // Queue methods
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");
        // Stack methods
        list.push("Alice Springs");

    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove(); // remove first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst(); // remove first element
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast(); // remove last element
        System.out.println(s3 + " was removed");

        // Queue/Deque poll methods
        String p1 = list.poll(); // remove first element
        System.out.println(p1 + " was removed");

        String p2 = list.pollFirst(); // remove first element
        System.out.println(p2 + " was removed");

        String p3 = list.pollLast(); // remove last element
        System.out.println(p3 + " was removed");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");

        System.out.println(list);
        String p4 = list.pop();
        System.out.println(p4 + " was removed");

    }

    private static void gettingElements(LinkedList<String> list) {

        System.out.println("Retrieved Element = " + list.get(4));

        System.out.println("First Element = " + list.getFirst());
        System.out.println("Last Element = " + list.getLast());

        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " + list.lastIndexOf("Melbourne"));

        // Queue retrieval method
        System.out.println("Element from element() = " + list.element());
        // Stack retrieval method
        System.out.println("Element form peek() = " + list.peek());
        System.out.println("Element form peekFirst() = " + list.peekFirst());
        System.out.println("Element form peekLast() = " + list.peekLast());
    }

    public static void printItinerary(LinkedList<String> list) {

        System.out.println("Trip starts at " + list.getFirst());
        for (int i = 1; i < list.size(); i++) {
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list) {

        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list) {
            System.out.println("--> From " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary3(LinkedList<String> list) {

        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
//        ListIterator<String> iterator = list.listIterator();
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()){
            var town = iterator.next();
            System.out.println("--> From " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list) {

        var iterator = list.iterator();
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            if(iterator.next().equals("Brisbane")) {
//                list.remove(); --> cannot use list method in iterator
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    private static void testIterator2(LinkedList<String> list) {

        var iterator = list.listIterator();
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            if(iterator.next().equals("Brisbane")) {
//                list.remove(); --> cannot use list method in iterator
                //iterator.remove();
                iterator.add("Lake Wivenhoe");
            }
        } // iterator go beyond last element after while loop

        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // nothing print out since the iterator go beyond the last element
        }

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        } // iterator go before first element after while loop

        System.out.println(list);

        var iterator2 = list.listIterator(3);
        System.out.println(iterator2.next());
        System.out.println(iterator2.previous());
    }
}
