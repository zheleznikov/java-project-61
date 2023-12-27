package hexlet.code.game;

import java.util.Scanner;

import static hexlet.code.core.GameEngine.WIN_RESULT;
import static hexlet.code.core.GameEngine.executeGame;
import static hexlet.code.core.Utils.createRandomNumber;

public class GCDGame {

    private static final int MAX_VALUE_FOR_FIRST_NUMBER = 25;
    private static final int MAX_VALUE_FOR_SECOND_NUMBER = 10;


    public static void play(Scanner scanner) {
        String taskCondition = "Find the greatest common divisor of given numbers.";
        String[][] gameData = createGameData(WIN_RESULT);
        executeGame(taskCondition, gameData, scanner);
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

    private static String[][] createGameData(int count) {
        String[][] gameData = new String[count][2];

        for (int i = 0; i < count; i++) {
            int firstNum = createRandomNumber(MAX_VALUE_FOR_FIRST_NUMBER);
            int secondNum = createRandomNumber(MAX_VALUE_FOR_SECOND_NUMBER);

            String question = firstNum + " " + secondNum;
            String answer = calcGcd(firstNum, secondNum);

            gameData[i] = new String[]{question, answer};
        }

        return gameData;
    }
}
