package hexlet.code.core;

public class Utils {

    public static int createRandomNumber(int max) {
        return (int) (Math.random() * (max));
    }

    public static int createRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
