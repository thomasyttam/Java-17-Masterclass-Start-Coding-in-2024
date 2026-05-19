package com.timbuchalka;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
/**
 *
 */
public class BankAccountTest {

    @org.junit.Test
    public void deposit() {
//        fail("This test has yet to be implemented");
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00);
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0)
    }

    @org.junit.Test
    public void withdraw() {
        fail("This test has yet to be implemented");
    }

    @org.junit.Test
    public void getBalance() {
        fail("This test has yet to be implemented");
    }

//    @org.junit.Test
//    public void dummyTest() {
//        assertEquals(20, 21);
//    }
}