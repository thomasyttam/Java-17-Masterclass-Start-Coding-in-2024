package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("------");
        list.forEach((var myString)->System.out.println(myString));

        System.out.println("------");
        String prefix = "nato";
        // String myString = "enclosing Method's myString -> lambda expression cannot use same variable name in the scope
        list.forEach((var myString)-> {
            char first = myString.charAt(0);
            System.out.println(prefix + " "+ myString + " means " + first);
        });
        // prefix = "NATO"; -> cannot re-assign prefix used in lambda expression need final or effectively final

        // int result = calculator((a, b) -> System.out.println(a + b), 5, 2); -> Error: System.out.println(a + b) cannot convert to int
        // int result = calculator((Integer a, var b) -> a + b, 5, 2); -> Error: for the type Interger or var, cannot mix use
        int result = calculator((a, b) -> a + b, 5, 2);
        var result2 = calculator((a, b) -> a / b, 10.0, 2.5);
    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {

        T result = function.operate(value1, value2);
        System.out.println("Result of operation: "  + result);
        return result;
    }
}
