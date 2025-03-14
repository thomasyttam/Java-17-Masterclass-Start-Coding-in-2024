package dev.lpa.burger;

public class Store {

    public static void main(String[] args) {

        Meal regularMeal = new Meal();
        System.out.println(regularMeal);

        Meal USregularMeal = new Meal(0.68);
        System.out.println(USregularMeal);
    }
}
