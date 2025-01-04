package dev.lpa;

public abstract class ProductOfSale {

    private String type;
    private double price;
    private String description;

    public ProductOfSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    // Getter
    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Setter
    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalesPrice(int quantity) {
        return (quantity * price);
    }

    public void printPricedItem(int quantity) {
        System.out.printf("%2d qty at %8.2f each, %-15s %-35s %n", quantity, price, type, description);
    }

    public abstract void showDetails();
}
