public class Main {

    public static void main(String[] args) {

        System.out.println("The sum of the digits in number 1234 is " + sumDigits(1234));
        System.out.println("The sum of the digits in number -125 is " + sumDigits(-125));
        System.out.println("The sum of the digits in number 4 is " + sumDigits(4));
        System.out.println("The sum of the digits in number 32123 is " + sumDigits(32123));

    }

    public static int sumDigits (int number) {
        int sum = 0;

        if (number < 0){
            return -1;
        }
//        while (number > 0) {
//            sum += number % 10; // sum the last digit
//            number /= 10; // remove the last digit
//        }
//        return sum;

        // more efficient from course
        while (number > 9) {
            sum += number % 10;
            number /= 10;
        }

        sum += number % 10;
        return sum;
    }
}
