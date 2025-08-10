package dev.lpa;

public class Main {

    public static void main(String[] args) {

//        below code check overflow for each loop
//        int maxMinusFive = Integer.MAX_VALUE - 5;
////        for (int j = 0, id = maxMinusFive; j < 10; id++, j++) {
//        for (int j = 0, id = maxMinusFive; j < 10; id = Math.incrementExact(id), j++) { // Math.incrementExact(id) check overflow
//                System.out.printf("Assigning id %,d%n", id);
//        }

        System.out.println(Math.abs(-50));
        System.out.println(Math.abs(Integer.MIN_VALUE));
//        System.out.println(Math.absExact(Integer.MIN_VALUE)); // overflow
        System.out.println(Math.abs((long)Integer.MIN_VALUE));

        System.out.println("Max = " + Math.max(10, -10));
        System.out.println("Min = " + Math.min(10.0000002, 10.001));
        System.out.println("Min = " + Math.min(10.0000002f, 10.001f)); // f float
        System.out.println("Min = " + Math.min(10.0000002, 10.001f)); // literal decimal is double

        System.out.println("Round Down = " + Math.round(10.2));
        System.out.println("Round Up = " + Math.round(10.8));
        System.out.println("Round ? = " + Math.round(10.5));

        System.out.println("Floor = " + Math.floor(10.8));
        System.out.println("Ceil = " + Math.ceil(10.2));

        System.out.println("Square root of 100 = " + Math.sqrt(100));
        System.out.println("2 to the third power (2*2*2) = " + Math.pow(2, 3));
        System.out.println("10 to the fifth power (10*10*10*10*10) = " + Math.pow(10, 5));

        for (int i = 0; i < 10; i++) {
//            System.out.println(Math.random());
//            System.out.println(Math.random() * 10);
//            System.out.println((int)(Math.random() * 10));
//            System.out.println((int)(Math.random() * 10) + 1);
            System.out.println((int)(Math.random() * 26) + 65);
        }
    }
}
