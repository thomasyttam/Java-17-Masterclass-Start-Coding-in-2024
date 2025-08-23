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
        Pattern htmlPattern = Pattern.compile("<[hH](?<level>\\d)>(.*)</[hH]\\d>"); // (xxx) xxx is the capture group, only one matching group, ?<xxx> matcher group name "xxx"
        Matcher htmlMatcher = htmlPattern.matcher(htmlSnippet);

        while (htmlMatcher.find()) {
//            System.out.println("group: " + htmlMatcher.group());
//            System.out.println("group0: " + htmlMatcher.group(0));
//            System.out.println("group0: " + htmlMatcher.group(1));
//            System.out.println(htmlMatcher.group(1) + " " +
//                    htmlMatcher.group(2));
            System.out.println(htmlMatcher.group("level") + " " +
                    htmlMatcher.group(2));
            System.out.println("index = " + htmlMatcher.start("level"));
        }

//        htmlMatcher.reset();
        htmlMatcher.results().forEach(mr -> System.out.println(
                mr.group(1) + " *** " + mr.group(2)));

        String tabbedText = """
                group1	group2	group3
                1	2	3
                a	b	d
                """;

        tabbedText.lines()
                .flatMap(s -> Pattern.compile("\\t").splitAsStream(s))
                .forEach(System.out::println);

        htmlMatcher.reset();
//        String updatedSnippet = htmlMatcher.replaceFirst("First Header");
        // below code don't work as replaceFirst reset matcher every time, and group(2) is not created before the matcher invoke
//        String updatedSnippet = htmlMatcher.replaceFirst(
//                "<em>" + htmlMatcher.group(2) + "</em>");
        // Take a function and call that function after match
        String updatedSnippet = htmlMatcher.replaceFirst((mr) ->
                "<em>" + mr.group(2) + "</em>");
        System.out.println("------------------");
        System.out.println(updatedSnippet);
        System.out.println(htmlMatcher.start() + " : " + htmlMatcher.end());
        System.out.println(htmlMatcher.group(2));

        htmlMatcher.usePattern(
                Pattern.compile("<([hH]\\d)>(.*)</\\1>")); // \\1, using same as backslash 1

        htmlMatcher.reset();
        System.out.println("------------------");
        System.out.println("Using Back Reference: \n" +
                htmlMatcher.replaceFirst("<em>$2</em>")); //$ back reference
    }
}
