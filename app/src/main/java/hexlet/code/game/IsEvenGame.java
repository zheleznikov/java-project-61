package hexlet.code.game;

import hexlet.code.core.GameEngine;

import static hexlet.code.core.GameEngine.WIN_RESULT;
import static hexlet.code.core.Utils.createRandomNumber;

public class IsEvenGame {

    private static final int MAX_VALUE_FOR_IS_EVEN_GAME = 99;

    public static void play() {
        String taskCondition = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] gameData = createGameData(WIN_RESULT);
        GameEngine.executeGame(taskCondition, gameData);
    }

    private static String[][] createGameData(int count) {
        String[][] gameData = new String[count][2];

        for (int i = 0; i < count; i++) {
            int question = createRandomNumber(MAX_VALUE_FOR_IS_EVEN_GAME);
            String answer = question % 2 == 0 ? "yes" : "no";
            gameData[i] = new String[]{String.valueOf(question), answer};
        }

        return gameData;
    }

}
