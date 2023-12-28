package hexlet.code.game;

import static hexlet.code.core.GameEngine.WIN_RESULT;
import static hexlet.code.core.GameEngine.executeGame;
import static hexlet.code.core.Utils.createRandomNumber;

public class IsPrimeGame {

    private static final int MAX_VALUE_FOR_IS_PRIME_GAME = 10;

    public static void play() {
        String taskCondition = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] gameData = createGameData(WIN_RESULT);
        executeGame(taskCondition, gameData);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static String[][] createGameData(int count) {
        String[][] gameData = new String[count][2];

        for (int i = 0; i < count; i++) {
            int question = createRandomNumber(1, MAX_VALUE_FOR_IS_PRIME_GAME);
            String answer = isPrime(question) ? "yes" : "no";
            gameData[i] = new String[]{String.valueOf(question), answer};
        }

        return gameData;
    }
}
