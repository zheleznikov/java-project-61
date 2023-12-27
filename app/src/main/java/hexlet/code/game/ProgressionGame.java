package hexlet.code.game;

import java.util.Scanner;

import static hexlet.code.core.GameEngine.WIN_RESULT;
import static hexlet.code.core.GameEngine.executeGame;
import static hexlet.code.core.Utils.createRandomNumber;

public class ProgressionGame {

    private static final int MAX_VALUE_FOR_STEP = 10;
    private static final int MAX_FIRST_VALUE_IN_PROGRESSION = 10;
    private static final int MIN_LENGTH_FOR_PROGRESSION = 5;
    private static final int MAX_LENGTH_FOR_PROGRESSION = 10;

    public static void play(Scanner scanner) {
        String taskCondition = "What number is missing in the progression?";
        String[][] gameData = createGameData(WIN_RESULT);

        executeGame(taskCondition, gameData, scanner);
    }


    private static String[] createProgression() {
        int step = createRandomNumber(1, MAX_VALUE_FOR_STEP);
        int length = createRandomNumber(MIN_LENGTH_FOR_PROGRESSION, MAX_LENGTH_FOR_PROGRESSION);
        int firstNum = createRandomNumber(MAX_FIRST_VALUE_IN_PROGRESSION);

        int[] progression = new int[length];
        progression[0] = firstNum;

        for (int i = 1; i < progression.length; i++) {
            progression[i] = progression[i - 1] + step;
        }

        int randomHiddenValue = progression[createRandomNumber(length)];

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {

            if (randomHiddenValue == progression[i]) {
                builder.append("..");
            } else {
                builder.append(progression[i]);
            }

            if (i != length - 1) {
                builder.append(" ");
            }

        }

        return new String[]{builder.toString(), String.valueOf(randomHiddenValue)};
    }

    private static String[][] createGameData(int count) {
        String[][] gameData = new String[count][2];

        for (int i = 0; i < count; i++) {
            String[] progression = createProgression();
            String question = progression[0];
            String answer = progression[1];
            gameData[i] = new String[]{question, answer};

        }

        return gameData;
    }


}
