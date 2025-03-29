package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("------");
        list.forEach((var myString)->System.out.println(myString));

        System.out.println("------");
        String prefix = "nato";
        // String myString = "enclosing Method's myString -> lambda expression cannot use same variable name in the scope
        list.forEach((var myString)-> {
            char first = myString.charAt(0);
            System.out.println(prefix + " "+ myString + " means " + first);
        });
        // prefix = "NATO"; -> cannot re-assign prefix used in lambda expression need final or effectively final
    }
}
