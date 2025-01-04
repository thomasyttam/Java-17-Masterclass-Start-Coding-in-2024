package dev.lpa;

import java.util.ArrayList;

public abstract class Store {

    private static ArrayList<ProductOfSale> productsOfSales = new ArrayList<>();

    public abstract void addItemToOrder(ProductOfSale product);

    public abstract void printOrderedItems(ArrayList<ProductOfSale> productsOfSales);

    public static void main(String[] args) {

        productsOfSales.add(new ArtObject("Oil Painting", 1350,
                "Impressionistic work by ABF in 2010"));
        productsOfSales.add(new ArtObject("Sculpture", 2000,
                "Brozne work by JKF, produced in 1950"));
    }
}
