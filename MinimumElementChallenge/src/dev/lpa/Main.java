package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // My solutions
        int[] userArray = myReadIntegers();
        System.out.println(Arrays.toString(userArray));
        System.out.println("min = " + myFindMind(userArray));

        // Course solutions
        int[] returnedArray = readIntegers();
        System.out.println(Arrays.toString(returnedArray));

        int returnMin = findMin(returnedArray);
        System.out.println("min = " + returnMin);
    }

    // My solutions
    private static int[] myReadIntegers(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input the size of the array");
        int size = scanner.nextInt(); // Get the array size
        int[] userArray = new int[size]; // Create empty array

        System.out.println("");
        for (int i = 0; i < userArray.length; i++) {
            System.out.println("Please enter the " + (i + 1) + " integer");
            userArray[i] = scanner.nextInt();
        }
        return userArray;
    }

    private static int myFindMind(int[] userArray) {
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] < minValue) {
                minValue = userArray[i];
            }
        }

        return minValue;
    }
    //

    // Course solution
    private static int[] readIntegers() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integers, separated by commas:");
        String input = scanner.nextLine();

        String[] splits = input.split(",");
        int[] values = new int[splits.length];

        for (int i = 0; i < splits.length; i++) {
            values[i] = Integer.parseInt(splits[i].trim()); // remove white space and convert to Integer
        }
        return values;
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int el : array) {
            if (el < min) {
                min = el;
            }
        }
        return min;
    }
}
