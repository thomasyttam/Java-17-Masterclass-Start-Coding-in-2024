package dev.lpa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

//        String sentence = "I like motorcycles.";
        String sentence = "I like B.M.W. motorcycles.";
        boolean matched = Pattern.matches("[A-Z].*[.]", sentence);
        System.out.println(matched + ": " + sentence);

        Pattern firstPattern = Pattern.compile("[A-Z].*?[.]");
        var matcher = firstPattern.matcher(sentence);
        System.out.println(matcher.matches() + ": " + sentence); // matches always from index 0
        System.out.println("sentence.length: " + sentence.length());
        System.out.println("Matched Ending Index: " + matcher.end());

        System.out.println(matcher.lookingAt() + ": " + sentence); // lookingAt always from index 0
        System.out.println("Matched Ending Index: " + matcher.end());
        System.out.println("Matched on : " +
                sentence.substring(0, matcher.end()));

        matcher.reset(); // if no reset, find start from matcher.end
        System.out.println(matcher.find() + ": " + sentence);
        System.out.println("Matched Ending Index: " + matcher.end());
        System.out.println("Matched on : " +
                sentence.substring(matcher.start(), matcher.end()));
        System.out.println("Matched on : " + matcher.group());

        String htmlSnippet = """
                <H1>My Heading</H1>
                <h2>Sub-heading</h2>
                <p>This is a paragraph about something.</p>
                <p>This is another paragraph about something else.</p>
                <h3>Summary</h3>
                """;

//        Pattern htmlPattern = Pattern.compile("<[hH]\\d>.*</[hH]\\d>");
        Pattern htmlPattern = Pattern.compile("<[hH]\\d>(.*)</[hH]\\d>"); // (xxx) xxx is the capture group
        Matcher htmlMatcher = htmlPattern.matcher(htmlSnippet);

        while (htmlMatcher.find()) {
            System.out.println("group: " + htmlMatcher.group());
            System.out.println("group0: " + htmlMatcher.group(0));
            System.out.println("group0: " + htmlMatcher.group(1));
//            System.out.println(htmlMatcher.group("level") + " " +
//                    htmlMatcher.group(2));
//            System.out.println("index = " + htmlMatcher.start("level"));
        }    }
}
