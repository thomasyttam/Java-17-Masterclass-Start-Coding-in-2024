public class Main {

    public static void main(String[] args) {

        for (int counter = 1; counter <= 5; counter++) {
            System.out.println(counter);
        }

//        System.out.println("10,000 at 2% interest rate = "  + calculateInterest(10000.0, 2.0));
//        System.out.println("10,000 at 2% interest rate = "  + calculateInterest(10000.0, 3.0));
//        System.out.println("10,000 at 2% interest rate = "  + calculateInterest(10000.0, 4.0));
//        System.out.println("10,000 at 2% interest rate = "  + calculateInterest(10000.0, 5.0));

        for (double rate = 2.0; rate <= 5.0; rate++) {
            double interestAmount = calculateInterest(10000.0, rate);
            System.out.println("10,000 at " + rate + "% interest rate = $" + interestAmount);
        }

        for (double rate = 7.5; rate <= 10.0; rate += 0.25){
            double interestAmount = calculateInterest(100.0, rate);
            if (interestAmount > 8.5) {
                break;
            }
            System.out.println("100 at " + rate + "% interest rate = $" + interestAmount);
        }
    }

    public static double calculateInterest(double amount, double interestRate) {

        return (amount * (interestRate / 100));
    }
}
