public class Meal {
    private Burger burger;
    private Item drink;
    private Item sideItem;

    // Default meal
    public Meal(){
        burger = new Burger("Regular", 5.0);
        drink = new Item("Drink", "coke", 1.0);
        sideItem = new Item("Side", "Fries", 1.5);
    }

    // Special meal
    public Meal(String burger, String drink, String sideItem) {
        if (burger.toLowerCase().equals("deluxe")){
            this.burger = new DeluxeBurger(burger, 8.5);
        } else{
            this.burger = new Burger(burger, 4.0);
        }
        this.drink = new Item("drink", drink, 1.0);
        this.sideItem = new Item("Side", sideItem, 1.5);
    }

    public double getTotalPrice() {
        if(burger instanceof DeluxeBurger){
            return burger.getAdjustedPrice();
        }

        return sideItem.getAdjustedPrice() + drink.getAdjustedPrice() + burger.getAdjustedPrice();
    }

    public void addToppings(String extra1,String extra2, String extra3){
        burger.addToppings(extra1, extra2, extra3);
    }

    public void addToppings(String extra1,String extra2, String extra3, String extra4, String extra5){
        if (burger instanceof DeluxeBurger db){
            db.addToppings(extra1,extra2, extra3, extra4, extra5);
        }else{
            addToppings(extra1, extra2, extra3);
        }
    }

    public void changeDrinkSize(String size){
        drink.setSize(size);
    }

    public void printItemList(){
        burger.printItem();
        if (burger instanceof DeluxeBurger){
            Item.printItem(drink.getName(), 0);
            Item.printItem(sideItem.getName(), 0);
        } else{
            drink.printItem();
            sideItem.printItem();
        }
        System.out.println("-".repeat(30));
        Item.printItem("TOTAL PRICE", getTotalPrice());
    }
}
