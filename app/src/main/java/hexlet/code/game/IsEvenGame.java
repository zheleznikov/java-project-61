package hexlet.code.game;

import java.util.Locale;
import java.util.Scanner;

import static hexlet.code.core.Utils.createRandomNumber;
import static hexlet.code.core.GameEngine.userAnswer;
import static hexlet.code.core.GameEngine.correctAnswer;
import static hexlet.code.core.GameEngine.executeGame;

public class IsEvenGame {


    public static void play() {
        String taskCondition = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        executeGame(IsEvenGame::execute, taskCondition);
    }

    private static boolean execute(Scanner scanner) {
        int random = createRandomNumber(99);
        System.out.println("Question: " + random);

        userAnswer = scanner.nextLine();

        boolean isRandomEven = random % 2 == 0;

        return isAnswerCorrect(userAnswer, isRandomEven);
    }

    private static boolean isAnswerCorrect(String answer, boolean isRandomEven) {
        if (isRandomEven) {
            correctAnswer = "yes";
            return "YES".equals(answer.toUpperCase(Locale.ROOT));
        }
        correctAnswer = "no";
        return "NO".equals(answer.toUpperCase(Locale.ROOT));
    }

}
