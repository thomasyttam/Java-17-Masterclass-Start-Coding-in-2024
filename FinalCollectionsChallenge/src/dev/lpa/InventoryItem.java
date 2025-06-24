package dev.lpa;

public class InventoryItem {

    private Product product;
    private double price;
    private int qtyTotal;
    private int qtyReserved;
    private int qtyReorder;
    private int qtyLow;

    public InventoryItem(Product product, double price, int qtyTotal, int qtyLow) {
        this.product = product;
        this.price = price;
        this.qtyTotal = qtyTotal;
        this.qtyLow = qtyLow;
        this.qtyReorder = qtyTotal;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    // reserved the item in the cart
    public boolean reserveItem(int qty) {

        if ((qtyTotal - qtyReserved) >= qty) {
            qtyReserved += qty;
            return true;
        }
        return false;
    }

    // if the cart is abandon, release item in reserved
    public void releaseItem(int qty) {
        qtyReserved -= qty;
    }

    // sell item in cart
    public boolean sellItem(int qty) {

        if (qtyTotal >= qty) { // check if the qtyTotal is greater than customer
            qtyTotal -= qty;
            qtyReserved -= qty; // release item in reserved as sold
            if (qtyTotal <= qtyLow) { // check if need reorder
                placeInventoryOrder();
            }
            return true;
        }
        return false;
    }

    private void placeInventoryOrder() {
        System.out.printf("Ordering qty %d : %s%n", qtyReorder, product);
    }

    @Override
    public String toString() {
        return "%s, $%.2f : [%04d,% 2d]".formatted(product, price, qtyTotal,
                qtyReserved);
    }
}
