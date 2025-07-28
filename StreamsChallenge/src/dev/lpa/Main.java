package dev.lpa;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        int seed = 1;
        var streamB = Stream.iterate(seed, i -> i <= 15, i -> i + 1)
                .map(i -> "B" + i);
//        streamB.forEach(System.out::println);

        seed += 15; // next seed should be 16
        var streamI = Stream.iterate(seed, i -> i + 1)
                .limit(15)
                .map(i -> "I" + i);
//        streamI.forEach(System.out::println);

        seed += 15; // next seed should be 31
        int nSeed = seed;
        String[] oLabels = new String[15];
        Arrays.setAll(oLabels, i -> "N" + (nSeed + i)); // use nSeed instead of seed because in lambda expression, the integer need to be final
        var streamN = Arrays.stream(oLabels);
//        streamN.forEach(System.out::println);

        seed += 15;
        var streamG = Stream.of("G46", "G47", "G48", "G49", "G50",
                "G51", "G52", "G53", "G54", "G55", "G56", "G57", "G58", "G59", "G60");
        streamG.forEach(System.out::println);
    }
}
