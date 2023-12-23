package hexlet.code.game;

import java.util.Locale;
import java.util.Scanner;

import static hexlet.code.core.GameEngine.*;
import static hexlet.code.core.Utils.createRandomNumber;

public class IsEvenGame {

    private static final int maxRandomValueForEvenPlay = 99;
    public static void play() {
        String taskCondition = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        executeGame(IsEvenGame::execute, taskCondition);
    }

    private static boolean execute(Scanner scanner) {

        int random = createRandomNumber(maxRandomValueForEvenPlay);
        System.out.println("Question: " + random);

        setUserAnswer(scanner.nextLine());

        boolean isRandomEven = random % 2 == 0;

        return isAnswerCorrect(getUserAnswer(), isRandomEven);
    }

    private static boolean isAnswerCorrect(String answer, boolean isRandomEven) {
        if (isRandomEven) {
            setCorrectAnswer("yes");
            return "YES".equals(answer.toUpperCase(Locale.ROOT));
        }
        setCorrectAnswer("no");
        return "NO".equals(answer.toUpperCase(Locale.ROOT));
    }

}
