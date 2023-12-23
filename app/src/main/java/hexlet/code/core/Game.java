package hexlet.code.core;

import hexlet.code.Cli;
import hexlet.code.game.CalculatorGame;
import hexlet.code.game.IsEvenGame;

public enum Game {

    Greet("1", Cli::greetUser),
    Even("2", IsEvenGame::play),
    Calc("3", CalculatorGame::play),
    Exit("0", () -> System.out.println("Bye") );

    public final String input;
    public final Runnable selected;

    Game(String input, Runnable selected) {
        this.input = input;
        this.selected = selected;
    }

}
