package dev.lpa.burger;

public class Meal {

    private class Item{

        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, 0);
        }
        
        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }
    }
}
