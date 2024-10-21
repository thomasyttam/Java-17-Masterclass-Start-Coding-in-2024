import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int validInput = 1;
        int sum = 0;
        do{

            int numberInput = 0;

            System.out.println("Enter number #" + validInput +":");

            Scanner scanner = new Scanner(System.in);
            try {
                numberInput = Integer.parseInt(scanner.nextLine());
                sum += numberInput;
                validInput++;

            } catch (NumberFormatException e){
                System.out.println("Invalid number");
            }
        } while(validInput <= 5);

        System.out.println("The sum of five number : " + sum);

    }
}
