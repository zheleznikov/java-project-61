package hexlet.code.game;

import java.util.Scanner;

import static hexlet.code.core.GameEngine.executeGame;
import static hexlet.code.core.GameEngine.setUserAnswer;
import static hexlet.code.core.GameEngine.setCorrectAnswer;
import static hexlet.code.core.GameEngine.getUserAnswer;
import static hexlet.code.core.GameEngine.getCorrectAnswer;
import static hexlet.code.core.Utils.createRandomNumber;

public class GCDGame {

    private static final int MAX_VALUE_FOR_FIRST_NUMBER = 25;
    private static final int MAX_VALUE_FOR_SECOND_NUMBER = 10;

    public static void play() {
        String taskCondition = "Find the greatest common divisor of given numbers.";
        executeGame(GCDGame::execute, taskCondition);
    }

    private static boolean execute(Scanner scanner) {
        int firstNum = createRandomNumber(MAX_VALUE_FOR_FIRST_NUMBER);
        int secondNum = createRandomNumber(MAX_VALUE_FOR_SECOND_NUMBER);

        System.out.println("Question: " + firstNum + " " + secondNum);

        setUserAnswer(scanner.nextLine());
        return isAnswerCorrect(firstNum, secondNum);
    }

    private static boolean isAnswerCorrect(int firstNum, int secondNum) {
        setCorrectAnswer(calcGcd(firstNum, secondNum));

        return getUserAnswer().equals(getCorrectAnswer());
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
