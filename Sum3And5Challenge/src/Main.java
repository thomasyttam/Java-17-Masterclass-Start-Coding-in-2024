public class Main {

    public static void main(String[] args) {
        int count = 0;
        int sum = 0;

        for (int i = 1; count < 5 && i <= 1000; i++){
            if ((i % 3 == 0) && (i % 5 == 0)){
                System.out.println("Number " + i + " can be divided by 3 and 5");
                count++;
                sum += i;
            }
        }

        System.out.println("Sum = " + sum);

    }
}
