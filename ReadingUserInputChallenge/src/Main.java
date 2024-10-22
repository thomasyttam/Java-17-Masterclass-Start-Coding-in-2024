import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int validInput = 1;
        double sum = 0;
        do{
            double numberInput = 0;
            System.out.println("Enter number #" + validInput +":");

            try {
                numberInput = Double.parseDouble(scanner.nextLine());
                sum += numberInput;
                validInput++;
            } catch (NumberFormatException e){
                System.out.println("Invalid number");
            }
        } while(validInput <= 5);

        System.out.println("The sum of five number : " + sum);

    }
}
