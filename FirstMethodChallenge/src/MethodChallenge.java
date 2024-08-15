public class MethodChallenge {

    public static void main(String[] args) {

        String playerName = "Tim";
        int position = 0;
        int newScore = 1500;

        position = calculateHighScorePosition(newScore);
        displayHighScorePosition(playerName, position);

        playerName = "Alvin";
        newScore = 1000;
        position = calculateHighScorePosition(newScore);
        displayHighScorePosition(playerName, position);

        playerName = "Bob";
        newScore = 500;
        position = calculateHighScorePosition(newScore);
        displayHighScorePosition(playerName, position);

        playerName = "Catherine";
        newScore = 100;
        position = calculateHighScorePosition(newScore);
        displayHighScorePosition(playerName, position);

        playerName = "David";
        newScore = 25;
        position = calculateHighScorePosition(newScore);
        displayHighScorePosition(playerName, position);

    }
    public static void displayHighScorePosition(String playerName, int highScoreposition) {

        System.out.println(playerName + " managed to get into position "
                + highScoreposition + " on the high score list");

    }

    public static int calculateHighScorePosition(int playerScore) {

        int position = 0; // initial the position

        if(playerScore >= 1000){
            position = 1;
        } else if (playerScore < 1000 && playerScore >= 500){
            position = 2;
        } else if (playerScore < 500 && playerScore >= 100){
            position = 3;
        } else {
            position = 4;
        }

        return position;
    }
}
