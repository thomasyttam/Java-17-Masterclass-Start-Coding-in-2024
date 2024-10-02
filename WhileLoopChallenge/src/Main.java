public class Main {

    public static void main(String[] args) {

        int startNumber = 5;
        int finishNumber = 20;
        int totalOdd = 0;
        int totalEven = 0;

        while (startNumber <= finishNumber) {
            if (totalEven >= 5) {
                break;
            }
            if (isEvenNumber(startNumber)){
                System.out.println("Even number " + startNumber);
                totalEven++;
            }
            else {
                totalOdd++;
            }
            startNumber++;
        }

        System.out.println("Total number of odd number = " + totalOdd);
        System.out.println("Total number of even number = " + totalEven);
    }

    public static boolean isEvenNumber (int number){
        return number % 2 == 0;
    }

}
