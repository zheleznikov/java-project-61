package hexlet.code.game;

import java.util.Locale;
import java.util.Scanner;

import static hexlet.code.core.Utils.createRandomNumber;
import static hexlet.code.core.GameEngine.userAnswer;
import static hexlet.code.core.GameEngine.correctAnswer;
import static hexlet.code.core.GameEngine.executeGame;

public class IsPrimeGame {

    public static void play() {
        String taskCondition = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        executeGame(IsPrimeGame::execute, taskCondition);
    }

    private static boolean execute(Scanner scanner) {
        int random = createRandomNumber(1, 10);
        System.out.println("Question: " + random);

        userAnswer = scanner.nextLine();

        boolean isPrime = isPrime(random);

        return isAnswerCorrect(userAnswer, isPrime);
    }

    private static boolean isAnswerCorrect(String answer, boolean isPrime) {
        if (isPrime) {
            correctAnswer = "yes";
            return "YES".equals(answer.toUpperCase(Locale.ROOT));
        }
        correctAnswer = "no";
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
