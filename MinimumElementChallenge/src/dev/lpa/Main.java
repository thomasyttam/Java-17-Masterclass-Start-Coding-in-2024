package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // My solutions
        int[] userArray = myReadIntegers();
        System.out.println(Arrays.toString(userArray));
        System.out.println("min = " + myFindMind(userArray));

        int[] returnArray = myReverseArray(userArray);
        System.out.println("Reversed array = " + Arrays.toString(returnArray));

        int[] returnArraytwo = myReverseCopy(userArray);
        System.out.println("Reversed array = " + Arrays.toString(returnArraytwo));
        System.out.println("Original array = " + Arrays.toString(userArray));

        // Course solutions
        int[] returnedArray = readIntegers();
        System.out.println(Arrays.toString(returnedArray));

        int returnMin = findMin(returnedArray);
        System.out.println("min = " + returnMin);

        reverse(returnedArray);

        int[] returnedArraytwo = reverseCopy(userArray);
        System.out.println("Reversed array = " + Arrays.toString(returnedArraytwo));
        System.out.println("Original array = " + Arrays.toString(returnedArray));

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

    private static int[] myReverseArray(int[] initArray){
        System.out.println("Original array = " + Arrays.toString(initArray));
        for (int i = 0; i < initArray.length / 2 ; i++) {
            int temp = initArray[i];
            initArray[i] = initArray[initArray.length - 1 - i];
            initArray[initArray.length -1 - i] = temp;
        }
        return initArray;
    }

    private static int[] myReverseCopy(int[] initArray){
        System.out.println("Original array = " + Arrays.toString(initArray));
        int[] reverseCopyArray = Arrays.copyOf(initArray, initArray.length);
        for (int i = 0; i < reverseCopyArray.length / 2 ; i++) {
            int temp = reverseCopyArray[i];
            reverseCopyArray[i] = reverseCopyArray[reverseCopyArray.length - 1 - i];
            reverseCopyArray[reverseCopyArray.length -1 - i] = temp;
        }
        return reverseCopyArray;
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

    private static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;

        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
            System.out.println("--> " + Arrays.toString(array));
        }
    }

    private static int[] reverseCopy(int[] array) {

        int[] reversedArray = new int[array.length];
        int maxIndex = array.length - 1;
        for(int el : array) {
            reversedArray[maxIndex--] = el;
        }
        return reversedArray;
    }
}
