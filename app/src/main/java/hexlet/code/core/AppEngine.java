package hexlet.code.core;


import hexlet.code.game.Cli;
import hexlet.code.game.GCDGame;
import hexlet.code.game.IsEvenGame;
import hexlet.code.game.CalculatorGame;
import hexlet.code.game.ProgressionGame;
import hexlet.code.game.IsPrimeGame;

import java.util.Scanner;

public class AppEngine {

    public static void start() {
        showMenu();
        try (Scanner scanner = new Scanner(System.in)) {

            String userSelect = scanner.nextLine();
            selectGame(userSelect, scanner);
        }
    }


    private static void showMenu() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter.");

        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        System.out.print("Your choice: ");
    }

    private static void selectGame(String userSelect, Scanner scanner) {
        switch (userSelect) {
            case "1" -> Cli.greetUser(scanner);
            case "2" -> IsEvenGame.play(scanner);
            case "3" -> CalculatorGame.play(scanner);
            case "4" -> GCDGame.play(scanner);
            case "5" -> ProgressionGame.play(scanner);
            case "6" -> IsPrimeGame.play(scanner);
            case "0" -> System.out.println("Bye!");
            default -> System.out.println("No such game");
        }

    }
}
