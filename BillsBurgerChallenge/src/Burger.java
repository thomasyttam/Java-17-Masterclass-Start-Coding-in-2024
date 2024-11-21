public class Burger extends Item{

    private Item extra1;
    private Item extra2;
    private Item extra3;

    public Burger(String name, Double price) {
        super("Burger", name, price);
    }

    @Override
    public String getName() {
        return super.getName() + " BURGER";
    }

    @Override
    public double getAdjustedPrice() {
        return getBasePrice() +
                ((extra1 == null) ? 0 : extra1.getBasePrice()) +
                ((extra2 == null) ? 0 : extra2.getBasePrice()) +
                ((extra3 == null) ? 0 : extra3.getBasePrice());
    }

    public double getExtraPrice(String topping) {
        return switch (topping.toUpperCase()){
            case "AVOCADO", "CHEESE" -> 1.0;
            case "BACON", "HAM", "SALAMI" -> 1.5;
            default -> 0.0;
        };
    }

    public void addToppings(String extra1, String extra2, String extra3) {
        this.extra1 = new Item("TOPPING", extra1, getExtraPrice(extra1));
        this.extra2 = new Item("TOPPING", extra2, getExtraPrice(extra2));
        this.extra3 = new Item("TOPPING", extra3, getExtraPrice(extra3));
    }

    public void printItemizedList() {
        printItem("BASE BURGER", getBasePrice());
        if (extra1 != null) {
            extra1.printItem();
        }
        if (extra2 != null) {
            extra2.printItem();
        }
        if (extra3 != null) {
            extra3.printItem();
        }
    }

    @Override
    public void printItem() {
        printItemizedList();
        System.out.println("-".repeat(30));
        super.printItem();
    }
}


class DeluxeBurger extends Burger {

    private Item extra4;
    private Item extra5;

    public DeluxeBurger(String name, Double price) {
        super(name, price);
    }

    public void addToppings(String extra1, String extra2, String extra3, String extra4, String extra5) {
        super.addToppings(extra1, extra2, extra3);
        this.extra4 = new Item("TOPPING", extra4, 0.00);
        this.extra5 = new Item("TOPPING", extra5, 0.00);
    }

    @Override
    public void printItemizedList() {
        super.printItemizedList();
        if (extra4 != null) {
            extra4.printItem();
        }
        if (extra5 != null) {
            extra5.printItem();
        }
    }

    @Override
    public double getExtraPrice(String topping) {
        return 0; // no extra price for deluxe burger
    }
}