package dev.lpa;

import dev.bank.BankAccount;

public class Main {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount(BankAccount.AccountType.CHECKING, 500);
        System.out.println(account);

    }
}
