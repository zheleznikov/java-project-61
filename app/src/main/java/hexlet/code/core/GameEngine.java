package hexlet.code.core;

import hexlet.code.game.Cli;

import java.util.Scanner;

public class GameEngine {
    public static final int WIN_RESULT = 3;

    public static void executeGame(String taskCondition, String[][] gameData, Scanner scanner) {
        String name = Cli.greetUser(scanner);
        System.out.println(taskCondition);

        int count = 0;
        while (count < WIN_RESULT) {
            String question = gameData[count][0];
            String correctAnswer = gameData[count][1];

            System.out.println("Question: " + question);

            String userAnswer = scanner.nextLine();

            if (correctAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
                count++;

            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

        if (count == WIN_RESULT) {
            System.out.println("Congratulations, " + name + "!");

        }

    }


}
