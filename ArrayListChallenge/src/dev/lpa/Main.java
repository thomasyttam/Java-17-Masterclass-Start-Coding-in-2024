package dev.lpa;

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

    private static void printActions() {
        String textBlock = """
                Available actions:
                0 - to shutdown
                1 - to add item(s) to list (comma delimited list)
                2 - to remove any items (comma delimited list)
                Enter a number for which action you want to do: """;
        System.out.println(textBlock + " ");
    }
}
