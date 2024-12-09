package dev.lpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//record GroceryItem(String name, String type, int count) {
//
//    public GroceryItem(String name){
//        this(name, "DAIRY", 1);
//    }
//
//    @Override
//    public String toString(){
//        return String.format("%d %s in %s", count, name.toUpperCase(), type);
//    }
//}

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();

        while(flag){
            printActions();
//            switch (scanner.nextLine()){
            try{switch (Integer.parseInt(scanner.nextLine())){ //handle non integer input
                case 1 -> {
                    addItems(groceries);
                    System.out.println(groceries);
                }
                case 2 -> removeItems(groceries);
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);}
            catch(Exception e){
                System.out.println("Please input Integer 0, 1, 2.");
            }
        }


        // My solution without remove duplicate item.
//        boolean goOn = true;
//        int userInput = 0;
//
//        ArrayList<String> groceryArrayList = new ArrayList<>();
//
//        while(goOn) {
//            System.out.println("""
//                Available actions:
//                0 - to shutdown
//                1 - to add item(s) to list (comma delimited list)
//                2 - to remove any items (comma delimited list)
//                Enter a number for which action you want to do: """);
//            Scanner scanner = new Scanner(System.in);
//            try {
//                userInput = Integer.parseInt(scanner.nextLine()); // not only get the integer and also get the return by nextLine
//            }
//            catch(Exception e){
//                System.out.println("Please input an integer");
//                userInput = -1;
//            }
//            if (userInput == 0){
//                goOn = false;
//            } else if(userInput == 1){
//                System.out.println("Please input the item(s) to add (comma delimited list)");
//                String itemInput = scanner.nextLine();
//                String[] items = itemInput.split(",");
//                groceryArrayList.addAll(List.of(items));
//                groceryArrayList.sort(Comparator.naturalOrder());
//                System.out.println(groceryArrayList);
//                goOn = true;
//            } else if(userInput == 2){
//                System.out.println("Please input the item(s) to remove (comma delimited list)");
//                String itemInput = scanner.nextLine();
//                String[] items = itemInput.split(",");
//                groceryArrayList.removeAll(List.of(items));
//                System.out.println(groceryArrayList);
//                goOn = true;
//            }
//        }
    }

    private static void addItems(ArrayList<String> groceries) {

        System.out.println("Add item(s) [seperate items by comma]: ");
        String[] items = scanner.nextLine().split(",");
        // groceries.addAll(List.of(items));
        for(String i : items) {
            String trimmed = i.trim().toLowerCase();  // remove white space and change to lowercase
            if (groceries.indexOf(trimmed) < 0) { // add the items if it is not found
                groceries.add(trimmed);
            }
        }
    }

    private static void removeItems(ArrayList<String> groceries) {

        System.out.println("Remove item(s) [seperate items by comma]: ");
        String[] items = scanner.nextLine().split(",");
        // groceries.addAll(List.of(items));
        for(String i : items) {
            String trimmed = i.trim().toLowerCase();  // remove white space and change to lowercase
            groceries.remove(trimmed);
        }
    }
    private static void printActions() {
        String textBlock = """
                Available actions:
                0 - to shutdown
                1 - to add item(s) to list (comma delimited list)
                2 - to remove any items (comma delimited list)
                Enter a number for which action you want to do: """;
        System.out.print(textBlock + " ");
    }
}
