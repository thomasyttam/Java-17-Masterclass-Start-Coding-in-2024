package dev.lpa;

public class BankAccount {

    private double balance;
//    private volatile double balance; // no help for none atomic operation
    private String name;

    private final Object lockName = new Object(); // create new object here
    private final Object lockBalance = new Object();

    public BankAccount(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public synchronized void setName(String name) {
    public void setName(String name) {
//        synchronized (this) {
//        synchronized (this.name) {
        synchronized (lockName) { // grab lock object in here
            this.name = name; // decide that lockName protects access to this.name
            System.out.println("Updated name = " + this.name);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
//    public synchronized void deposit(double amount) {

        try {
            System.out.println("Deposit - Talking to the teller at the bank...");
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        Double boxedBalance = this.balance;

        // add synchronized (this) { } to include context inside
//        synchronized (boxedBalance) { // synchronized local variable is bad, it is on own stack not shared
        synchronized (lockBalance) {
//        synchronized (this) { // this -> current instance, intrinsic lock to object, not primitive type
            double origBalance = balance;
            balance += amount;
            System.out.printf("STARTING BALANCE: %.0f, DEPOSIT (%.0f)" +
                    " : NEW BALANCE = %.0f%n", origBalance, amount, balance);
            addPromoDollars(amount);
        }
    }

    private void addPromoDollars(double amount) {

        if (amount >= 5000) {
            synchronized (lockBalance) {
                System.out.println("Congratulations, you earned a promotional deposit.");
                balance += 25;
            }
        }
    }

    // one thread is executing a synchronized method for an object,
    // all other threads that invoke synchronized methods for the same object,
    // synchronized -> lock the object
    public synchronized void withdraw(double amount) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        double origBalance = balance;
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f)" +
                    " : NEW BALANCE = %.0f%n", origBalance, amount, balance);
        } else {
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f)" +
                    ": INSUFFICIENT FUNDS!", origBalance, amount);
        }
    }
}
