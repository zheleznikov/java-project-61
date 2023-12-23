package hexlet.code.game;

import java.util.Scanner;

import static hexlet.code.core.Utils.createRandomNumber;
import static hexlet.code.game.GameEngine.correctAnswer;
import static hexlet.code.game.GameEngine.userAnswer;
import static hexlet.code.game.GameEngine.executeGame;

public class CalculatorGame {

    public static void play() {
        String taskCondition = "What is the result of the expression?";
        executeGame(CalculatorGame::execute, taskCondition);
    }

    private static boolean execute(Scanner scanner) {
        int firstNum = createRandomNumber(9);
        int secondNum = createRandomNumber(9);
        String operation = getRandomOperation();

        System.out.println("Question: " + firstNum + " " + operation + " " + secondNum);

        userAnswer = scanner.nextLine();
        return isAnswerCorrect(firstNum, secondNum, operation);
    }

    private static boolean isAnswerCorrect(int firstNum, int secondNum, String operation) {
        correctAnswer = switch (operation) {
            case "+" -> String.valueOf(firstNum + secondNum);
            case "-" -> String.valueOf(firstNum - secondNum);
            case "*" -> String.valueOf(firstNum * secondNum);
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };

        return userAnswer.equals(correctAnswer);
    }

    private static String getRandomOperation() {
        String[] operations = {"+", "-", "*"};
        return operations[createRandomNumber(3)];
    }

}
