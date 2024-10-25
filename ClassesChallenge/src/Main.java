public class Main {

    public static void main(String[] args) {

        Account account = new Account();
        account.setAccountNumber("12345678");
        account.setAccountBalance(1000.00);
        account.setCustomerName("Thomas Tam");
        account.setEmail("myemail@thomas.com");
        account.setPhoneNumber("(647)-123-5678");

        account.withdrawMoney(100.0);
        account.depositMoney(100);
        account.withdrawMoney(100);
        account.withdrawMoney(55.55);
        account.withdrawMoney(1055.55);


    }
}
