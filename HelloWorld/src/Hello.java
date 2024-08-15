public class Hello {

    public static void main(String[] args) {
        System.out.println("Hello, Tim");

        boolean isAlien = false;
        if (isAlien == false) {
            System.out.println("It is not an alien!");
            System.out.println("And I am scared of aliens");
        }

        int topScore = 80;
        if(topScore < 100) {
            System.out.println("You got the high score!");
        }

        int secondTopScore = 95;
        if ((topScore > secondTopScore) && (topScore < 100)) {
            System.out.println("Greater than second top score and less than 100");
        }

        if((topScore > 90) || (secondTopScore <= 90)) {
            System.out.println("Either or both of the conditions are true");
        }

        int newValue = 50;
        if (newValue == 50){
            System.out.println("This is true");
        }

        boolean isCar = false;
        if(!isCar) {
            System.out.println("This is not supposed to happen");
        }

        String makeOfCar = "Volkswagen";
        boolean isDomestic = makeOfCar == "Volkswagen" ? false : true;

        if(isDomestic) {
            System.out.println("This car is domestic to our country");
        }

        String s = (isDomestic) ? "This car is domestic" : "This car is not domestic";

        System.out.println(s);

        double firstDouble = 20.00d, secondDouble = 80.00d;
        double resultDouble = (firstDouble + secondDouble) * 100.00d;
        System.out.println("The result is " + resultDouble);

        double reminderDouble = resultDouble % 40.00d;
        System.out.println("The reminder is " + reminderDouble);

        boolean isReminderZero = (reminderDouble == 0.00d) ? true : false;
        System.out.println(isReminderZero);

        if(!isReminderZero) {
            System.out.println("Got some reminder");
        }

    }
}
