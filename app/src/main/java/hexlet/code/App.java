package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        showGameList();

        String game = scanner.nextLine();
        displayGame(game, scanner);
    }

    private static void showGameList() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }



    private static void displayGame(String userSelect, Scanner scanner) {
        switch (userSelect) {
            case "1" -> Cli.greetUser(scanner);
            case "2" -> IsEvenGame.play(scanner);
            case "0" -> System.out.println("Bye");
            default ->  System.out.println("No game matched");
        }
    }


}
