package dev.lpa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(
                new FileReader("article.txt"))) {

//            System.out.printf("%d lines in files%n", br.lines().count());
            Pattern pattern = Pattern.compile("\\p{javaWhitespace}+");
            System.out.printf("%,d words in file%n",
                    br.lines()
                            .flatMap(pattern::splitAsStream)
//                            .flatMap(l -> Arrays.stream(l.split(pattern.toString())))
                            .count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
