package dev.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {

    private static int lastCustomerId = 10_000_000;

    private final String name;
    private final int customerId;
    private final List<BankAccount> accounts = new ArrayList<>();

//    public BankCustomer(String name, double checkingAmount, double savingsAmount) {
    BankCustomer(String name, double checkingAmount, double savingsAmount) {
        this.name = name;
        this.customerId = lastCustomerId++;
        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, checkingAmount));
        accounts.add(new BankAccount(BankAccount.AccountType.SAVINGS, savingsAmount));
    }

    public String getName() {
        return name;
    }

//    public int getCustomerId() {
//        return customerId;
//    }
    // change to String
    public String getCustomerId() {
        return "%015d".formatted(customerId);
    }

    public List<BankAccount> getAccounts() {
//        return accounts;
//        return new ArrayList<>(accounts); // create defensive copy
        return List.copyOf(accounts); // create unmodifiable collection, prevent add, delete or reassign accounts
    }

    public BankAccount getAccount(BankAccount.AccountType type) {

        for (var account : accounts) {
            if (account.getAccountType() == type) {
                return account;
            }
        }
        return null;
    }

    @Override
    public String toString() {

        String[] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(name, customerId,
                String.join("\n\t", accountStrings));
    }
}
