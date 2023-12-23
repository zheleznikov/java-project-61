package hexlet.code.game;

import java.util.Scanner;

import static hexlet.code.core.GameEngine.*;
import static hexlet.code.core.Utils.createRandomNumber;

public class CalculatorGame {

    private static final int maxRandomValueForCalculator = 9;

    public static void play() {
        String taskCondition = "What is the result of the expression?";
        executeGame(CalculatorGame::execute, taskCondition);
    }

    private static boolean execute(Scanner scanner) {
        int firstNum = createRandomNumber(maxRandomValueForCalculator);
        int secondNum = createRandomNumber(maxRandomValueForCalculator);
        String operation = getRandomOperation();

        System.out.println("Question: " + firstNum + " " + operation + " " + secondNum);

        setUserAnswer(scanner.nextLine());
        return isAnswerCorrect(firstNum, secondNum, operation);
    }

    private static boolean isAnswerCorrect(int firstNum, int secondNum, String operation) {
        String correctAnswer = switch (operation) {
            case "+" -> String.valueOf(firstNum + secondNum);
            case "-" -> String.valueOf(firstNum - secondNum);
            case "*" -> String.valueOf(firstNum * secondNum);
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
        setCorrectAnswer(correctAnswer);

        return getUserAnswer().equals(getCorrectAnswer());
    }

    private static String getRandomOperation() {
        String[] operations = {"+", "-", "*"};
        return operations[createRandomNumber(operations.length)];
    }

}
