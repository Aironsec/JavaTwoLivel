package lesson1.HomeWork1;

import static lesson1.HomeWork1.Main.rnd;

public class Track extends Trainer {
    private final double length = (double) rnd.nextInt(100000) / 10;

    @Override
    boolean move(Action action) {
        System.out.println("Дорожка " + length + " м. длины!");
        action.run();
        if (action.getRunLength() >= length) {
            System.out.println("Пробежал");
            return true;
        } else {
            System.out.println("Не пробежал");
            return false;
        }
    }
}
