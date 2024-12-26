package dev.lpa;

import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions) {

    public Customer(String name, Double initialDeposit) {
        this(name.toUpperCase(), new ArrayList<Double>(500));
        transactions.add(initialDeposit);
    }
}

public class Main {

    public static void main(String[] args) {

        Customer thomas = new Customer("Thomas", 1000.00);
        System.out.println(thomas);
    }
}

class Bank {

    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    private Customer getCustomer(String customerName){
        for(var customer : customers) {
            if(customer.name().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        System.out.printf("Customer (%s) was not found.%n", customerName);

        return null;
    }

    private void addNewCustomer(String customerName, double initialDeposit) {
        if(getCustomer(customerName) == null){
            Customer customer = new Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("New customer added: " + customer);
        }
    }
}