package hexlet.code.game;

import java.util.Scanner;

import static hexlet.code.core.Utils.createRandomNumber;
import static hexlet.code.core.GameEngine.correctAnswer;
import static hexlet.code.core.GameEngine.userAnswer;
import static hexlet.code.core.GameEngine.executeGame;

public class GCDGame {

    public static void play() {
        String taskCondition = "Find the greatest common divisor of given numbers.";
        executeGame(GCDGame::execute, taskCondition);
    }

    private static boolean execute(Scanner scanner) {
        int firstNum = createRandomNumber(25);
        int secondNum = createRandomNumber(10);

        System.out.println("Question: " + firstNum + " " + secondNum);

        userAnswer = scanner.nextLine();
        return isAnswerCorrect(firstNum, secondNum);
    }

    private static boolean isAnswerCorrect(int firstNum, int secondNum) {
        correctAnswer = calcGcd(firstNum, secondNum);

        return userAnswer.equals(correctAnswer);
    }

    private static String calcGcd(int x, int y) {
        while (x != 0 && y != 0) {

            if (x > y) {
                x = x % y;
            } else {
                y = y % x;
            }
        }

        return String.valueOf(x + y);
    }
}
