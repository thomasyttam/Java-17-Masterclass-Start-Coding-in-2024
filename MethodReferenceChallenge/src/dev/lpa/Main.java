package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {

    private static Random newRandom = new Random();

    private record Person(String first) {

        public String last(String s) {
            return first + " " + s.substring(0, s.indexOf(" "));
        }
    }

    public static void main(String[] args) {

//        List<String> nameslist = new ArrayList<>(List.of("Anna", "Bob", "Charlie", "David",
//                "Ethan", "Francis", "Gavin", "Helen", "Iris"));
//
//        nameslist.forEach(s -> System.out.println(s.toUpperCase()));
//        String[] names = new String[nameslist.size()];
//        nameslist.toArray(names);

        String[] names = {"Anna", "Bob", "Cameron", "Donald", "Eva", "Francis"};

        Person tim = new Person("Tim");
        List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                String::toUpperCase,
                s -> s += " " + getRandomChar('A', 'Z') + ".",
                s -> s += " " + reverse(s, 0, s.indexOf(" ")),
                Main::reverse,
                String::new,
//                s -> new String("Howdy" + s),
                String::valueOf,
                tim::last,
                (new Person("MARY"))::last
        ));

        applyChanges(names, list);
     }

     private static void applyChanges(String[] names,
                                      List<UnaryOperator<String>> stringFunctions) {

        List<String> backedByArray = Arrays.asList(names);
        for(var function: stringFunctions) {
            backedByArray.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));
        }
     }

     private static char getRandomChar(char startChar, char endChar) {
        return (char) newRandom.nextInt((int) startChar, (int) endChar +1);
     }

     private static String reverse(String s) {
        return reverse(s, 0 , s.length());
     }

     private static String reverse(String s, int start, int end) {
        return new StringBuilder(s.substring(start, end)).reverse().toString();
     }
}
