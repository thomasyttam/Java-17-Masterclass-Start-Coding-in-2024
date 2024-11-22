package dev.lpa;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] myIntArray = new int[10];
        myIntArray[0] = 45;
        myIntArray[1] = 1;
        myIntArray[5] = 50;
        System.out.println(myIntArray[1]);

        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 3.5;
        System.out.println(myDoubleArray[2]);

        // int[] firstTen = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] firstTen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("first = " + firstTen[0]);
        int arrayLength = firstTen.length;
        System.out.println("length of array = " + arrayLength);
        System.out.println("last = " + firstTen[arrayLength-1]);

        int [] newArray;
        newArray = new int[] {5, 4, 3, 2, 1};
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
        System.out.println();
        int[] newSecondArray;
        newSecondArray = new int[5];
        for (int i = 0; i < newSecondArray.length; i++) {
            newSecondArray[i] = newSecondArray.length - i;
        }
        for (int i = 0; i < newSecondArray.length; i++) {
            System.out.print(newSecondArray[i] + " ");
        }
        System.out.println();
        for(int element : newSecondArray) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println(newSecondArray);
        System.out.println(Arrays.toString(newSecondArray));

        Object objectArray = newSecondArray;
        if (objectArray instanceof int[]){
            System.out.println("objectArray is really an int array");
        }
        
        // Object array can store different type of each elements
        Object[] diffArray = new Object[4];
        diffArray[0] = "Hello";
        diffArray[1] = new StringBuilder("World");
        diffArray[2] = newArray;
        diffArray[3] = 10;
        for (int i = 0; i < diffArray.length; i++) {
            System.out.println(diffArray[i]);
        }
        for(Object element : diffArray) {
            System.out.print(element + " ");
        }
    }
}
