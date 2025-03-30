package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

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
        // int result = calculator((Integer a, var b) -> a + b, 5, 2); -> Error: for the type Interger or var, cannot mix use var with other parameters
        // int result = calculator((a, b) -> {return a + b;}, 5, 2);
        int result = calculator((a, b) -> a + b, 5, 2);
        var result2 = calculator((a, b) -> a / b, 10.0, 2.5);
        var result3 = calculator(
                (a, b) -> a.toUpperCase() + " " + b.toUpperCase(),
                "Ralph", "Kramden");

        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659});

        coords.forEach(s->System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> p1 = (lat, lng) ->
                System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);
    }

//    public static <T> T calculator(Operation<T> function, T value1, T value2) {
//
//        T result = function.operate(value1, value2);
//        System.out.println("Result of operation: "  + result);
//        return result;
//    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {

        T result = function.apply(value1, value2);
        System.out.println("Result of operation: "  + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer){
        consumer.accept(t1, t2);
    }
}
