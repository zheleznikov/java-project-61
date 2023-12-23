package hexlet.code.game;

import java.util.Locale;
import java.util.Scanner;

import static hexlet.code.core.GameEngine.*;
import static hexlet.code.core.Utils.createRandomNumber;

public class IsPrimeGame {

    private static final int maxRandomValueForIsPrime = 10;

    public static void play() {
        String taskCondition = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        executeGame(IsPrimeGame::execute, taskCondition);
    }

    private static boolean execute(Scanner scanner) {
        int random = createRandomNumber(1, maxRandomValueForIsPrime);
        System.out.println("Question: " + random);

        setUserAnswer(scanner.nextLine());

        boolean isPrime = isPrime(random);

        return isAnswerCorrect(getUserAnswer(), isPrime);
    }

    private static boolean isAnswerCorrect(String answer, boolean isPrime) {
        if (isPrime) {
            setCorrectAnswer("yes");
            return "YES".equals(answer.toUpperCase(Locale.ROOT));
        }
        setCorrectAnswer("no");
        return "NO".equals(answer.toUpperCase(Locale.ROOT));
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
