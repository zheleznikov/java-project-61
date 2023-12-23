package hexlet.code.core;

import hexlet.code.game.Cli;

import java.util.Scanner;
import java.util.function.Function;

public class GameEngine {
    public static final int WIN_RESULT = 3;
    private static String correctAnswer;
    private static String userAnswer;

    public static void setCorrectAnswer(String answer) {
        GameEngine.correctAnswer = answer;
    }

    public static void setUserAnswer(String answer) {
        GameEngine.userAnswer = answer;
    }

    public static String getCorrectAnswer() {
        return correctAnswer;
    }

    public static String getUserAnswer() {
        return userAnswer;
    }

    public static void executeGame(Function<Scanner, Boolean> func, String taskCondition) {
        try (Scanner scanner = new Scanner(System.in)) {
            String name = Cli.greetUser(scanner);
            System.out.println(taskCondition);

            int count = 0;
            while (count < WIN_RESULT) {

                if (func.apply(scanner)) {
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


}
