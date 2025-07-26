package dev.lpa;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main (String[] args) {

        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < (start + 15); i++) {
                bingoPool.add("" + c + i);
//                System.out.println("" + c + i);
            }
            start += 15;
        }

        Collections.shuffle(bingoPool);
        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("------------------------------------");

//        List<String> firstOnes = bingoPool.subList(0, 15);
        List<String> firstOnes = new ArrayList<>(bingoPool.subList(0, 15)); // create a copy of original list
        firstOnes.sort(Comparator.naturalOrder());
        firstOnes.replaceAll(s -> {
            if (s.indexOf('G') == 0 || s.indexOf("O") == 0) {
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.print(updated + " ");
                return updated;
            }
            return s;
        });
        System.out.println("\n----------------------------------");

        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("------------------------------------");

        // listing of these five operations called a stream pipeline
        // each stream with dot start operation on its own line
        bingoPool.stream() // this line is the source
                .limit(15) // limit the size
                // begin of intermediate operation
                .filter(s -> s.indexOf('G') == 0 || s.indexOf("O") == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted()
                // end of intermediate operation
                .forEach(s -> System.out.print(s + " ")); // this line terminal operation, forEach return void which cannot provide data for next operation

//        no need to built pipeline in one piece
        var tempStream = bingoPool.stream()
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf("O") == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted();
//        line of stream operation do not executed until below line
        tempStream.forEach(s -> System.out.print(s + " "));

//        tempStream.forEach(s -> System.out.print(s + " ")); // Stream has already been linked or consumed, object stream can use once only

        System.out.println("\n----------------------------------");

        // check if stream has effect on bingoPool collection -> no effect
//        for (int i = 0; i < 15; i++) {
//            System.out.println(bingoPool.get(i));
//        }

        String[] strings = {"One", "Two", "Three"};
        Arrays.stream(strings)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        Stream.of("Six", "Five", "Four")
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}