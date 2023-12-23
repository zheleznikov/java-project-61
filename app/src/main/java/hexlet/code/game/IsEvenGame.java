package hexlet.code.game;

import hexlet.code.Cli;

import java.util.Locale;
import java.util.Scanner;

import static hexlet.code.core.Utils.createRandomNumber;

public class IsEvenGame {

    private final static int winResult = 3;
    private static String correctAnswer;
    private static String userAnswer;

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        String name = Cli.greetUser(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int count = 0;
        while (count < winResult) {

            if (executeGame(scanner)) {
                System.out.println("Correct!");
                count++;

            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
                break;
            }
        }

        if (count == winResult) System.out.println("Congratulations, " + name  + "!");
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
