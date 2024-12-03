package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count) {

    public GroceryItem(String name){
        this(name, "DAIRY", 1);
    }
}

public class Main {

    public static void main(String[] args) {

//        Object array not check element 2 is not GroceryItem
//        Object[] groceryArray = new Object[3];
//        groceryArray[0] = new GroceryItem("milk");
//        groceryArray[1] = new GroceryItem("apple", "produce", 6);
//        groceryArray[2] = "5 oranges";
//        System.out.println(Arrays.toString(groceryArray));


        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apple", "PRODUCE", 6);
        groceryArray[2] = new GroceryItem("orange","PRODUCE", 5);
        System.out.println(Arrays.toString(groceryArray));

        ArrayList objectList = new ArrayList();
        
    }
}
