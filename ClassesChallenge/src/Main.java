public class Main {

    public static void main(String[] args) {

//        Account account = new Account("12345678", 1000.00, "Thomas Tam",
//                "myemail@thomas.com", "(647)123-5678");
        Account account = new Account();
        account.getAccountNumber();
        account.getAccountBalance();

//        account.setAccountNumber("12345678");
//        account.setAccountBalance(1000.00);
//        account.setCustomerName("Thomas Tam");
//        account.setEmail("myemail@thomas.com");
//        account.setPhoneNumber("(647)123-5678");

        account.withdrawMoney(100.0);
        account.depositMoney(100);
        account.withdrawMoney(100);
        account.withdrawMoney(55.55);
        account.withdrawMoney(1055.55);

        Account timsAccount = new Account("Tim", "tim@email.com", "12345");
        System.out.println("Account no: " + timsAccount.getAccountNumber() +
                "; name " + timsAccount.getCustomerName() +".");

    }
}
