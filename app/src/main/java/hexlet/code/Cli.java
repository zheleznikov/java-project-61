package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void greetUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain IsEvenGame!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        scanner.close();
    }

    public static String greetUser(Scanner scanner) {
        System.out.println("Welcome to the Brain IsEvenGame!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

}
