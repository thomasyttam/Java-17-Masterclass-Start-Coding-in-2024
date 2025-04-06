package dev.lpa;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {

        String[] names = {"Anna", "Bob", "Corale", "David", "Ed", "Fred", "Gary"};

        System.out.println("--> Original strings");
        System.out.println(Arrays.toString(names));

        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("--> Transform to Uppercase");
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);

    }

    // get the random char between startChar and endChar
    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    // reverse the first name and return the reversed string
    public static String getReversedName(String firstname) {
        return new StringBuilder(firstname).reverse().toString();
    }
}
