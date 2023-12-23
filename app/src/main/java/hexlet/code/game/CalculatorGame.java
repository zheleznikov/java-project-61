package hexlet.code.game;

import hexlet.code.Cli;

import java.util.Scanner;

import static hexlet.code.core.Utils.createRandomNumber;

public class CalculatorGame {

    private final static int winResult = 3;
    private static String correctAnswer;
    private static String userAnswer;

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        String name = Cli.greetUser(scanner);
        System.out.println("What is the result of the expression?");

        int count = 0;
        while (count < winResult) {

            if (executeGame(scanner)) {
                System.out.println("Correct!");
                count++;

            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

        if (count == winResult) System.out.println("Congratulations, " + name + "!");
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
