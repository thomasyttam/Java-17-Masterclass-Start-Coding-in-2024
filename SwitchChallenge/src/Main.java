public class Main {

    public static void main(String[] args) {

        char message = 'B';

        switch (message) {
            case 'A':
                System.out.println(message + " = Able");
                break;
            case 'B':
                System.out.println(message + " = Baker");
                break;
            case 'C':
                System.out.println(message + " = Charlie");
                break;
            case 'D':
                System.out.println(message + " = Dog");
                break;
            case 'E':
                System.out.println(message + " = Easy");
                break;
            default:
                System.out.println("Letter " + message + " was not found in the switch");
                break;
        }
    }
}
