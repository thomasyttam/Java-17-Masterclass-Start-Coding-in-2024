package dev.lpa;

public class Main {

    public static void main(String... args) {
        System.out.println("Hello World again");
        String[] splitStrings = "Hello World again".split(" ");

        printText(splitStrings);
        printTextSecond(splitStrings);
        System.out.println("_".repeat(20));

        String[] testArray = {"Hello", "World", "again"};

        // printText("Hello"); -> Cannot work as the function need String arrays
        printTextSecond("Hello");
        System.out.println("_".repeat(20));
        // printText("Hello", "World", "again"); -> Cannot work as the function need String arrays
        // printText({"Hello", "World", "again"}); -> Cannot use Array initializer
        printText(testArray);
        printText(new String[]{"Hello", "World", "again"});
        printTextSecond("Hello", "World", "again");
        printTextSecond();

        String[] sArray = {"first", "second", "third", "fourth", "fifth"};
        System.out.println(String.join(", ", sArray));
    }

    // String array in the parameter (String[])
    private static void printText(String[] textList){
        for(String t : textList){
            System.out.println(t);
        }
    }

    // variable arguments in the parameter (String...)
    private static void printTextSecond(String... textList){
        for(String t : textList){
            System.out.println(t);
        }
    }
}
