package com.timbuchalka;

/**
 *
 */
public class BankAccountTestParameterized {

    private BankAccount account;

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }
}
