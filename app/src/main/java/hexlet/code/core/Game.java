package hexlet.code.core;

import hexlet.code.game.CalculatorGame;
import hexlet.code.game.Cli;
import hexlet.code.game.GCDGame;
import hexlet.code.game.IsEvenGame;
import hexlet.code.game.ProgressionGame;
import hexlet.code.game.IsPrimeGame;

public enum Game {

    Greet("1", Cli::greetUser),
    Even("2", IsEvenGame::play),
    Calc("3", CalculatorGame::play),
    GCD("4", GCDGame::play),
    Progression("5", ProgressionGame::play),
    Prime("6", IsPrimeGame::play),
    Exit("0", () -> System.out.println("Bye"));

    private final String input;
    private final Runnable selected;

    Game(String userInput, Runnable selectedFunc) {
        this.input = userInput;
        this.selected = selectedFunc;
    }

    public String getInput() {
        return this.input;
    }

    public Runnable getSelected() {
        return this.selected;
    }

}
