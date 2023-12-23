package hexlet.code.game;

import java.util.Scanner;

import static hexlet.code.core.Utils.createRandomNumber;
import static hexlet.code.game.GameEngine.*;

public class CalculatorGame {


    public static void play() {
        Scanner scanner = new Scanner(System.in);
        String name = Cli.greetUser(scanner);
        System.out.println("What is the result of the expression?");

        runGame(name, scanner, CalculatorGame::executeGame);
        scanner.close();
    }

    private static boolean executeGame(Scanner scanner) {
        int firstNum = createRandomNumber(9);
        int secondNum = createRandomNumber(9);
        String operation = getRandomOperation();

        System.out.println("Question: " + firstNum + " " + operation + " " + secondNum);

        userAnswer = scanner.nextLine();
        return isAnswerCorrect(firstNum, secondNum, operation);
    }

    private static boolean isAnswerCorrect(int firstNum, int secondNum, String operation) {
        correctAnswer = (switch (operation) {
            case "+" -> String.valueOf(firstNum + secondNum);
            case "-" -> String.valueOf(firstNum - secondNum);
            case "*" -> String.valueOf(firstNum * secondNum);
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        });

        return userAnswer.equals(correctAnswer);
    }

    private static String getRandomOperation() {
        String[] operations = {"+", "-", "*"};
        return operations[createRandomNumber(3)];
    }

}
