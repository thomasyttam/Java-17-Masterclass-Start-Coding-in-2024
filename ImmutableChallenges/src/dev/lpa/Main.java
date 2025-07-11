package dev.lpa;

import dev.bank.Bank;
import dev.bank.BankAccount;
import dev.bank.BankCustomer;

//class MyAccount extends BankAccount {
//
//    MyAccount (AccountType accountType, double balance) {
//        super(accountType, balance); -> cannot use super as the constructor is not public or protected
//    }
//}

public class Main {

    public static void main(String[] args) {

//        BankAccount account =
//                new BankAccount(BankAccount.AccountType.CHECKING, 500);
//        System.out.println(account);

//        BankCustomer joe = new BankCustomer("Joe", 500.00,
//                10000.00);
//        System.out.println(joe);

        Bank bank = new Bank(3214567);
        bank.addCustomer("Joe", 500.00,
                10000.00);

        BankCustomer joe = bank.getCustomer("000000010000000");
        System.out.println(joe);

        if (bank.doTransaction(joe.getCustomerId(), BankAccount.AccountType.CHECKING,
                35)) {
            System.out.println(joe);
        }

        if (bank.doTransaction(joe.getCustomerId(), BankAccount.AccountType.CHECKING,
                -535)) {
            System.out.println(joe);
        }

        if (bank.doTransaction(joe.getCustomerId(), BankAccount.AccountType.CHECKING,
                -535.01)) {
            System.out.println(joe);
        }

        BankAccount checking = joe.getAccount(BankAccount.AccountType.CHECKING);
        var transactions = checking.getTransactions();
        transactions.forEach((k, v) -> System.out.println(k + ": " + v));

        // Cannot add transaction directly
//        transactions.put(3L, new Transaction(1, 1, Integer.parseInt(joe.getCustomerId()), 500));

//        System.out.println("------------------");
//        for (var tx : transactions.values()) {
//            tx.setCustomerId(2);
//            tx.setAmount(10000.00);
//        }
//        transactions.forEach((k, v) -> System.out.println(k + ": " + v));

        joe.getAccount(BankAccount.AccountType.CHECKING).getTransactions().clear(); // no effect as modifiable collection with immutable data
        System.out.println("------------------");
        joe.getAccount(BankAccount.AccountType.CHECKING).getTransactions()
                .forEach((k, v) -> System.out.println(k + ": " + v));

//        List<BankAccount> accounts = joe.getAccounts();
//        accounts.clear();
//        System.out.println(joe);

        // cannot create new BankAccount as constructor is private
//        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, 150000));
//        System.out.println(joe);
    }
}
