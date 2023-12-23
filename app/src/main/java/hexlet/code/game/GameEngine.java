package hexlet.code.game;

import java.util.Scanner;
import java.util.function.Function;

public class GameEngine {
    public final static int winResult = 3;
    public static String correctAnswer;
    public static String userAnswer;

    public static void runGame(String name, Scanner scanner, Function<Scanner, Boolean> func) {
        int count = 0;
        while (count < winResult) {

            if (func.apply(scanner)) {
                System.out.println("Correct!");
                count++;

            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

        if (count == winResult) System.out.println("Congratulations, " + name + "!");
    }


}
