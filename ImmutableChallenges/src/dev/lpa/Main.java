package dev.lpa;

import dev.bank.BankAccount;
import dev.bank.BankCustomer;

import java.util.List;

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

        BankCustomer joe = null;
        List<BankAccount> accounts = joe.getAccounts();
        accounts.clear();
        System.out.println(joe);

        // cannot create new BankAccount as constructor is private
//        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, 150000));
//        System.out.println(joe);
    }
}
