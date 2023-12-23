package hexlet.code.core;

import java.util.Scanner;

/**
 <h2>Продвинутая реализация выбора игры</h2>
 <p>Преимущества - уменьшает возможность ошибки при добавлении новой игры
 или изменении бизнес-логики..</p>
 <p>Недостатки - использования enum и интерфейса runnable может быть неочевидно
 на ранней стадии изучения языка.</p>
 */
public class EngineAdvanced {

    public static void start() {
        showMenu();

        Scanner scanner = new Scanner(System.in);
        String userSelect = scanner.nextLine();

        selectGame(userSelect);
        scanner.close();
    }


    private static void showMenu() {
        System.out.println("Please enter the game number and press Enter.");
        for (Game game : Game.values()) {
            System.out.println(game.input + " - " + game);
        }
        System.out.print("Your choice: ");
    }

    private static void selectGame(String userSelect) {
        int count = 0;
        for (Game game : Game.values()) {

            if (userSelect.equals(game.input)) {
                game.selected.run();
                count++;
            }
        }

        if (count == 0) System.out.println("No game matched");
    }
}
