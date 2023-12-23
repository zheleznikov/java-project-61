package hexlet.code.game;

import java.util.Scanner;

import static hexlet.code.core.Utils.createRandomNumber;
import static hexlet.code.core.GameEngine.userAnswer;
import static hexlet.code.core.GameEngine.correctAnswer;
import static hexlet.code.core.GameEngine.executeGame;

public class ProgressionGame {

    public static void play() {
        String taskCondition = "What number is missing in the progression?";
        executeGame(ProgressionGame::execute, taskCondition);
    }

    private static boolean execute(Scanner scanner) {
        String progression = createProgression();

        System.out.println("Question: " + progression);
        userAnswer = scanner.nextLine();

        return isAnswerCorrect();
    }

    private static boolean isAnswerCorrect() {
        return correctAnswer.equals(userAnswer);
    }

    private static String createProgression() {
        int step = createRandomNumber(1, 10);
        int length = createRandomNumber(5, 10);
        int firstNum = createRandomNumber(10);

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

        correctAnswer = String.valueOf(randomHiddenValue);
        return builder.toString();
    }


}
