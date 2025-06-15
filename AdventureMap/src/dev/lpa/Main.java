package dev.lpa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AdventureGame game = new AdventureGame();
        game.play("road");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String direction = scanner.nextLine().trim().toUpperCase().substring(0, 1); // cannot handle "\n"
            if (direction.equals("Q")) break;
            game.move(direction);
        }
    }
}
