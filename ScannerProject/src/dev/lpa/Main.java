package dev.lpa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(
                new BufferedReader(new FileReader("fixedWidth.txt")))) {
//        try (Scanner scanner = new Scanner(new FileReader("fixedWidth.txt"))) {
//        try (Scanner scanner = new Scanner(Path.of("fixedWidth.txt"))) {
//        try (Scanner scanner = new Scanner(new File("fixedWidth.txt"))) {

//            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
//            }
//            System.out.println(scanner.delimiter());
//            scanner.useDelimiter("$");
//            scanner.tokens().forEach(System.out::println);

//            scanner.findAll("[A-Za-z]{10,}")
//                    .map(MatchResult::group)
//                    .distinct()
//                    .sorted()
//                    .forEach(System.out::println);

            var results = scanner.findAll(
                            "(.{15})(.{3})(.{12})(.{8})(.{2}).*")
                    .skip(1) // skip the first line of the file
                    .map(m -> m.group(3).trim()) // trim to remove the white space of the fixed width 12
                    .distinct()
                    .sorted()
                    .toArray(String[]::new);
            System.out.println(Arrays.toString(results));
        } catch (IOException e) {
//        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
