package hexlet.code.game;

import hexlet.code.core.GameEngine;

import java.util.Scanner;

import static hexlet.code.core.GameEngine.WIN_RESULT;
import static hexlet.code.core.Utils.createRandomNumber;

public class IsEvenGame {

    private static final int MAX_VALUE_FOR_IS_EVEN_GAME = 99;

    public static void play(Scanner scanner) {
        String taskCondition = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] gameData = createGameData(WIN_RESULT);
        GameEngine.executeGame(taskCondition, gameData, scanner);
    }

    private static String[][] createGameData(int count) {
        String[][] gameData = new String[count][2];

        for (int i = 0; i < count; i++) {
            int random = createRandomNumber(MAX_VALUE_FOR_IS_EVEN_GAME);
            String isRandomEven = random % 2 == 0 ? "yes" : "no";
            gameData[i] = new String[]{String.valueOf(random), isRandomEven};
        }

        return gameData;
    }

}
