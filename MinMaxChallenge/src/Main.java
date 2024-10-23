import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double maxNumber = 0;
        double minNumber = 0;
        int loopCount = 0;

        do {

            System.out.println("Please enter a number or any character to quit: ");

            try {
                double numberInput = Double.parseDouble(scanner.nextLine());
                if (loopCount == 0 || numberInput > maxNumber){
                    maxNumber = numberInput;
                }
                if (loopCount == 0 || numberInput < minNumber){
                    minNumber = numberInput;
                }
                loopCount++;
//                System.out.println("Maximum number: " + maxNumber);
//                System.out.println("Minimum number: " + minNumber);
            } catch (NumberFormatException nfe){
                System.out.println("Quit the program");
                break;
            }
        } while (true);

        if (loopCount > 0) {
            System.out.println("Max number = " + maxNumber + ". Min number = " + minNumber);
        } else{
            System.out.println("No valid data entered.");
        }
    }
}
