package hexlet.code.game;

import java.util.Scanner;

import static hexlet.code.core.GameEngine.*;
import static hexlet.code.core.Utils.createRandomNumber;

public class ProgressionGame {

    private static final int maxRandomValueForStep = 10;
    private static final int maxFirstValueInProgression = 10;
    private static final int minLengthForProgression = 5;
    private static final int maxLengthForProgression = 10;

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
        int step = createRandomNumber(1, maxRandomValueForStep);
        int length = createRandomNumber(minLengthForProgression, maxLengthForProgression);
        int firstNum = createRandomNumber(maxFirstValueInProgression);

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
