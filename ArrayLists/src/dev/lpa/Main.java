package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count) {

    public GroceryItem(String name){
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString(){
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
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


        // Array
        System.out.println("Array");
        System.out.println("-".repeat(20));
        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apple", "PRODUCE", 6);
        groceryArray[2] = new GroceryItem("orange","PRODUCE", 5);
        System.out.println(Arrays.toString(groceryArray));
        System.out.println("-".repeat(20));

        System.out.println("Array List");
        System.out.println("-".repeat(20));
        // General list can add any type
        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");

        // Specify the type in the array list
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        // groceryList.add("Yogurt"); -> cannot work, need GroceryItem
        groceryList.add(new GroceryItem("Milk"));
        groceryList.add(new GroceryItem("Oranges", "PRODUCE", 5));
        groceryList.add(0,
                new GroceryItem("Apples", "PRODUCE", 6));
        groceryList.set(0,
                new GroceryItem("Apples", "PRODUCE", 6));
        System.out.println(groceryList);
        groceryList.remove(1); // remove the item in index 1
        System.out.println(groceryList);

    }
}
