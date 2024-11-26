package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // My solution
        int[] newArray = getRandomIntArray(5);
        System.out.println("New Array: " + Arrays.toString(newArray));

        int[] sortedArray = Arrays.copyOf(newArray,newArray.length);
        Arrays.sort(sortedArray);
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        for (int i = 0; i < sortedArray.length / 2; i++) {
            int tempInt = 0;
            tempInt = sortedArray[sortedArray.length - 1 - i];
            sortedArray[sortedArray.length - 1 - i] = sortedArray[i];
            sortedArray[i] = tempInt;
        }
        System.out.println("Reverse Sorted Arrays: " + Arrays.toString(sortedArray));
        //
        System.out.println("New Array: " + Arrays.toString(newArray));
        // Solution from course
        System.out.println(Arrays.toString(sortIntegers(newArray)));
    }

    private static int[] getRandomIntArray(int len){
        Random random = new Random();
        int[] intArray = new int[len];

        for (int i = 0; i < len; i++) {
            intArray[i] = random.nextInt(1000);
        }
        return intArray;
    }

    // Solution from course
    private static int[] sortIntegers(int[] array) {
        System.out.println(Arrays.toString(array));
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if(sortedArray[i] < sortedArray[i + 1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                    System.out.println("----->" + Arrays.toString(sortedArray));
                }
            }
            System.out.println("--->" + Arrays.toString(sortedArray));
        }

        return sortedArray;
    }
}
