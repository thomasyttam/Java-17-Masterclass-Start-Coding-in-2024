package dev.lpa;

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
