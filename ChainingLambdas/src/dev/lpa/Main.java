package dev.lpa;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        String name = "Tim";
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));
    }
}
