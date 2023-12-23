package hexlet.code.core;

import java.util.Scanner;

public class AppEngine {

    public static void start() {
        showMenu();
        try (Scanner scanner = new Scanner(System.in)) {
            String userSelect = scanner.nextLine();
            selectGame(userSelect);
        }
    }


    private static void showMenu() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter.");
        for (Game game : Game.values()) {
            System.out.println(game.input + " - " + game);
        }
        System.out.print("Your choice: ");
    }

    private static void selectGame(String userSelect) {
        int count = 0;
        for (Game game : Game.values()) {

            if (userSelect.equals(game.input)) {
                game.selected.run();
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No such game");
        }
    }
}
