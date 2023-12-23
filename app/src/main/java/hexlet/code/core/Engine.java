package hexlet.code.core;

import hexlet.code.Cli;
import hexlet.code.game.CalculatorGame;
import hexlet.code.game.IsEvenGame;

import java.util.Scanner;

/**
    <h2>Базовая реализация выбора игры</h2>
    <p>Преимущества - интуитивно-понятна.</p>
    <p>Недостатки - возможное исправление кода в двух местах: в методе <b>showMenu</b> и
    <b>selectGame</b>при каком-либо изменении бизнес-логики приложения.</p>
 */
public class Engine {

    public static void start() {
        showMenu();
        Scanner scanner = new Scanner(System.in);

        String userSelect = scanner.nextLine();
        selectGame(userSelect, scanner);
    }

    private static void showMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    private static void selectGame(String userSelect, Scanner scanner) {
        switch (userSelect) {
            case "1" -> Cli.greetUser(scanner);
            case "2" -> IsEvenGame.play();
            case "3" -> CalculatorGame.play();
            case "0" -> System.out.println("Bye");
            default ->  System.out.println("No game matched");
        }
    }


}
