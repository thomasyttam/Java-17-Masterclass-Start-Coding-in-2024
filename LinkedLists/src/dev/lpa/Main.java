package dev.lpa;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        // LinkedList<String> placetoVisit = new LinkedList<>();
        var placetoVisit = new LinkedList<String>();

        placetoVisit.add("Sydney");
        placetoVisit.add(0,"Canberra");
        System.out.println(placetoVisit);

        addMoreElements(placetoVisit);
        System.out.println(placetoVisit);

        removeElements(placetoVisit);
        System.out.println(placetoVisit);
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
}
