public class Main {

    public static void main(String[] args) {

        Item coke = new Item("drink", "coke", 1.50);
        coke.printItem();
        coke.setSize("LARGE");
        coke.printItem();

        Item avocado = new Item ("Topping", "avocado", 1.50);
        avocado.printItem();

        System.out.println("-".repeat(30));

        Burger burger = new Burger("regular", 4.00);
        burger.addToppings("BACON", "CHEESE", "MAYO");
        burger.printItem();

        Meal meal = new Meal();
        meal.addToppings("BACON", "MAYO", "CHEESE");
        meal.changeDrinkSize("LARGE");
        meal.printItemList();

        Meal mealTwo = new Meal("Sandwich", "Orange Juice", "Salad");
        mealTwo.addToppings("TOMATO", "CHEESE", "HAM");
        mealTwo.changeDrinkSize("SMALL");
        mealTwo.printItemList();

        Meal mealThree = new Meal("deluxe", "Orange Juice", "Salad");
        mealThree.addToppings("TOMATO", "CHEESE", "HAM","APPLE", "LETTUCE");
        mealThree.changeDrinkSize("SMALL");
        mealThree.printItemList();
    }
}
