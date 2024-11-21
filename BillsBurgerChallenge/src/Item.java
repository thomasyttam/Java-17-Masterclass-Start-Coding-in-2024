public class Item {
    private String type; //Drink, SideItems
    private String name;
    private double price;
    private String size = "MEDIUM";

    public Item(String type, String name, Double price) {
        this.type = type.toUpperCase();
        this.name = name.toUpperCase();
        this.price = (price < 0) ? 0 : price; // price cannot be negative
    }

    public String getName(){
        if (type.equals("SIDE") || type.equals("DRINK")){
            return size + " " + name;
        }
        return name;
    }

    public double getBasePrice() {
        return price;
    }

    public double getAdjustedPrice() {
        return switch(size){
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    public void setSize(String size) {
        this.size = size.toUpperCase();
    }

    public static void printItem(String name, double price) {
        System.out.printf("%-20s:%8.2f%n", name, price);
    }

    public void printItem() {
        printItem(getName(), getAdjustedPrice());
    }

}