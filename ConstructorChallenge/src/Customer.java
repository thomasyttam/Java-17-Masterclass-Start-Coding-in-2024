public class Customer {

    private String name;
    private double creditLimit;
    private String email;


    public Customer(String newName, double newCreditLimit, String newEmail) {
        this.name = newName;
        this.creditLimit = newCreditLimit;
        this.email = newEmail;
        System.out.println("Three parameters constructor called");
    }

    public Customer(){
        this("Thomas Tam", "thomas@myemail.com");
        System.out.println("No parameters constructor called");
    }

    public Customer(String newName, String newEmail){
        this(newName, 1000, newEmail);
        System.out.println("Two parameters constructor called");
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

}
