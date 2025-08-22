package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String helloWorld = "%s %s".formatted("Hello", "World");
        String helloWorld2 = String.format("%s %s", "Hello", "World");
        System.out.println("Using string's formatted method: " + helloWorld);
        System.out.println("Using String.format: " + helloWorld2);

        String helloWorld3 = Main.format("%s %s", "Hello", "World");
        System.out.println("Using Main.format: " + helloWorld3);

        String testString = "Anyone can Learn abc's, 123's, and any regular expression";
        String replacement = "(-)";

        String[] patterns = {
                "abc",
                "123",
                "A",
                "[abc]", // [] means match anyone inside square bracket, c is match
                "[123]", // [] means match anyone inside square bracket, 1 is match
                "[A]",
                "ab|bc", // means ab or bc match find
                "[a-z]", // means a to z match find
                "[0-9]", // means 0 to 9 match find
                "[A-Z]", // means A toZz match find
                "[a-zA-Z]", // means a to z and A to Z match find
                "[a-zA-Z]*",
                "[0-9]*", // find the first character before Anyone
                "[A-Z]*",
                "[0-9]+", // replace all digit first find
                "[0-9]{2}", // replace first 2 digit find
                "[a-zA-Z]*$", // match end of the text
                "^[a-zA-Z]{3}", // match start of text
                "[aA]ny\\b", // match
        };

        System.out.println("Original String: " + testString);
        for (String pattern : patterns) {
            String output = testString.replaceFirst(pattern, replacement);
            System.out.println("Pattern: " + pattern + " => " + output);
        }

        // Song of the Witches in MacBeth, a Play by Shakespeare
        String paragraph = """
                Double, double toil and trouble;
                Fire burn and caldron bubble.
                Fillet of a fenny snake,
                In the caldron boil and bake
                Eye of newt and toe of frog,
                Wool of bat and tongue of dog,
                Adder's fork and blind-worm's sting,
                Lizard's leg and howlet's wing,
                For a charm of powerful trouble,
                Like a hell-broth boil and bubble.
                """;

//        String[] lines = paragraph.split("\n"); // split per newline
        String[] lines = paragraph.split("\\R"); // line breaker matcher
        System.out.println("This paragraph has " + lines.length + " lines");
        String[] words = paragraph.split("\\s"); // white space, new line matcher
        System.out.println("This paragraph has " + words.length + " words");
        System.out.println(paragraph.replaceAll("[a-zA-Z]+ble",
                "[GRUB]"));

        Scanner scanner = new Scanner(paragraph);
        System.out.println(scanner.delimiter()); // use whitespace as default for delimiter
        scanner.useDelimiter("\\R"); // change delimiter to \\R

//        while (scanner.hasNext()) {
//            String element = scanner.next();
//            System.out.println(element);
//        }

        scanner.tokens() // token introduce in JDK9
//                .map(s -> Arrays.stream(s.split("\\s")).count()) // count words each line
                .map(s -> s.replaceAll("\\p{Punct}", "")) // remove punctuation
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .filter(s -> s.matches("[a-zA-Z]+ble"))
                .forEach(System.out::println);
        scanner.close();

        System.out.println("-".repeat(30));

        scanner = new Scanner(paragraph);
        System.out.println(scanner.findInLine("[a-zA-Z]+ble")); // first find
        System.out.println(scanner.findInLine("[a-zA-Z]+ble")); // second find
        scanner.close();
    }

    private static String format(String regexp, String... args) {

        int index = 0;
//        while (regexp.contains("%s")) {
        while (regexp.matches(".*%s.*")) {
            regexp = regexp.replaceFirst("%s", args[index++]);
        }
        return regexp;
    }
}
