public class Main {

    public static void main(String[] args) {
        System.out.println(getDuration(3945));  // This is the first test case
        System.out.println(getDuration(65, 45));    // This is the second test case
    }

    public static String getDuration(int seconds) {
        String timeInString = "";

        if (seconds < 0) {
            timeInString = "Second should be greater than or equal to zero." ;
        } else {
            int minutes = seconds / 60;
            timeInString = getDuration(minutes, seconds % 60);
        }
        return timeInString;
    }

    public static String getDuration(int minutes, int seconds) {
        String timeInString = "";
        if (minutes < 0){
            if (seconds >= 0 && seconds <= 59){
                timeInString = "Minutes should be greater than or equal to zero.";
            } else {
                timeInString = "Minutes should be greater than or equal to zero. And seconds should be between 0 to 59.";
            }
        } else {
            if (seconds >= 0 && seconds <= 59){
                int hours = minutes / 60;

                int remainingMinutes = minutes % 60;
                int remainingSeconds = seconds % 60;

                timeInString = (hours + "h " + remainingMinutes + "m " + remainingSeconds + "s");

            } else{
                timeInString = "Seconds should be between 0 to 59.";
            }
        }

        return timeInString;

    }

}
