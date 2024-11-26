package dev.lpa;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray;
        int[] anAnotherArray = Arrays.copyOf(myIntArray,myIntArray.length);

        System.out.println("myIntArray: " + myIntArray);
        System.out.println("anotherArray: " + anotherArray);
        System.out.println("anAnotherArray: " + anAnotherArray);

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));


        anotherArray[0] = 1;
        // Change the value of the array
        modifyArray(myIntArray);

        System.out.println("after change myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after change anotherArray = " + Arrays.toString(anotherArray));

        // Cannot change the value of x
        int x = -1;
        modifyInt(x);
        System.out.println(x);

    }

    private static void modifyArray(int[] array){
        array[1] = 2;
    }

    private static void modifyInt(int one){
        one = 2;
    }
}
