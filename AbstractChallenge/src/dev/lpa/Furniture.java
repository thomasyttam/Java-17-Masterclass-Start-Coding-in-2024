package dev.lpa;

public class Furniture extends ProductOfSale{
    public Furniture(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("This " + this.getType() + " was manufactured in North Carolina.");
        System.out.printf("The price of the piece is $%6.2f.%n", this.getPrice());
        System.out.println(this.getDescription() + ".");
    }

}
