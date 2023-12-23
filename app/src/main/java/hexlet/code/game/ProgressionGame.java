package hexlet.code.game;

import java.util.Scanner;

import static hexlet.code.core.GameEngine.executeGame;
import static hexlet.code.core.GameEngine.setUserAnswer;
import static hexlet.code.core.GameEngine.setCorrectAnswer;
import static hexlet.code.core.GameEngine.getUserAnswer;
import static hexlet.code.core.GameEngine.getCorrectAnswer;
import static hexlet.code.core.Utils.createRandomNumber;

public class ProgressionGame {

    private static final int MAX_VALUE_FOR_STEP = 10;
    private static final int MAX_FIRST_VALUE_IN_PROGRESSION = 10;
    private static final int MIN_LENGTH_FOR_PROGRESSION = 5;
    private static final int MAX_LENGTH_FOR_PROGRESSION = 10;

    public static void play() {
        String taskCondition = "What number is missing in the progression?";
        executeGame(ProgressionGame::execute, taskCondition);
    }

    private static boolean execute(Scanner scanner) {
        String progression = createProgression();

        System.out.println("Question: " + progression);
        setUserAnswer(scanner.nextLine());

        return isAnswerCorrect();
    }

    private static boolean isAnswerCorrect() {
        return getCorrectAnswer().equals(getUserAnswer());
    }

    private static String createProgression() {
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

        setCorrectAnswer(String.valueOf(randomHiddenValue));
        return builder.toString();
    }


}
