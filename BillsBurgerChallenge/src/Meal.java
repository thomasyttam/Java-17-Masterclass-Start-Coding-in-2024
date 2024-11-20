public class Meal {
    Burger burger;
    Item drink;
    Item sideItem;

    // Defalut meal
    public Meal(){
        burger = new Burger();
        drink = new Item();
        sideItem = new Item();
    }

    // Special meal
    public Meal(Burger burger, Item drink, Item sideItem) {
        this.burger = burger;
        this.drink = drink;
        this.sideItem = sideItem;
    }

    public void addToppings(){

    }

    public void changeDrinkSize(String size){

    }

    public void printItemList(){

    }

    public void printTotal() {

    }
}
