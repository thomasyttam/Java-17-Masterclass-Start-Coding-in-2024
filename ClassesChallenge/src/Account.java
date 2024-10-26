public class Account {

    private String accountNumber;
    private double accountBalance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Account () {
        System.out.println("Empty constructor called.");
    }

    public Account(String accountNumber, double accountBalance, String customerName, String email, String phoneNumber) {
        System.out.println("Account constructor with parameters called");
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;


    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositMoney(double moneyIn) {
        this.accountBalance += moneyIn;
        System.out.println("Deposit of $" + moneyIn + "." + "Now account Balance = " + this.accountBalance + ".");
    }

    public void withdrawMoney(double moneyOut) {
        if (this.accountBalance >= moneyOut) {
            accountBalance -= moneyOut;
            System.out.println("Withdraw of $" + moneyOut + "." + "Now account Balance = " + this.accountBalance + ".");
        } else{
            System.out.println("Account Balance less than withdraw amount. Account Balance only $" + this.accountBalance + ".");
        }

    }
}
