public class Main {

    public static void main(String[] args) {

        Customer firstCustomer = new Customer("Abby", 10000, "Abby@email.com");

        System.out.println("Name: " + firstCustomer.getName() + ". "
                + "Credit limit: $" + firstCustomer.getCreditLimit() + ". "
                + "Email: " + firstCustomer.getEmail() + ".");

        Customer secondCustomer = new Customer("Bob", "Bob@bob.ccom");

        System.out.println("Name: " + secondCustomer.getName() + ". "
                + "Credit limit: $" + secondCustomer.getCreditLimit() + ". "
                + "Email: " + secondCustomer.getEmail() + ".");

        Customer thirdCustomer = new Customer();

        System.out.println("Name: " + thirdCustomer.getName() + ". "
                + "Credit limit: $" + thirdCustomer.getCreditLimit() + ". "
                + "Email: " + thirdCustomer.getEmail() + ".");

    }


}
