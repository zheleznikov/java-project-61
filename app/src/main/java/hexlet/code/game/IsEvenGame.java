package hexlet.code.game;

import java.util.Locale;
import java.util.Scanner;

import static hexlet.code.core.Utils.createRandomNumber;
import static hexlet.code.game.GameEngine.*;

public class IsEvenGame {


    public static void play() {
        Scanner scanner = new Scanner(System.in);
        String name = Cli.greetUser(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        runGame(name, scanner, IsEvenGame::executeGame);
        scanner.close();
    }

    private static boolean executeGame(Scanner scanner) {
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
