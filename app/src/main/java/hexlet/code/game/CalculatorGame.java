package hexlet.code.game;

import java.util.Scanner;

import static hexlet.code.core.GameEngine.WIN_RESULT;
import static hexlet.code.core.GameEngine.executeGame;
import static hexlet.code.core.Utils.createRandomNumber;

public class CalculatorGame {

    private static final int MAX_NUM_FOR_CALCULATOR = 9;

    public static void play(Scanner scanner) {
        String taskCondition = "What is the result of the expression?";
        String[][] gameData = createGameData(WIN_RESULT);
        executeGame(taskCondition, gameData, scanner);
    }

    private static String getCorrectAnswer(int firstNum, int secondNum, String operation) {
        return switch (operation) {
            case "+" -> String.valueOf(firstNum + secondNum);
            case "-" -> String.valueOf(firstNum - secondNum);
            case "*" -> String.valueOf(firstNum * secondNum);
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };

    }
    private static String getRandomOperation() {
        String[] operations = {"+", "-", "*"};
        return operations[createRandomNumber(operations.length)];
    }

    private static String[][] createGameData(int count) {
        String[][] gameData = new String[count][2];

        for (int i = 0; i < count; i++) {

            int firstNum = createRandomNumber(MAX_NUM_FOR_CALCULATOR);
            int secondNum = createRandomNumber(MAX_NUM_FOR_CALCULATOR);
            String operation = getRandomOperation();

            String question = firstNum + " " + operation + " " + secondNum;
            String answer = getCorrectAnswer(firstNum, secondNum, operation);

            gameData[i] = new String[]{question, answer};

        }

        return gameData;
    }

}
