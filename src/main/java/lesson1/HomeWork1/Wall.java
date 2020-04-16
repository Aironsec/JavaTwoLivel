package lesson1.HomeWork1;

import static lesson1.HomeWork1.Main.rnd;

public class Wall extends Trainer {
    private final double height = (double) rnd.nextInt(25) / 10;

    @Override
    boolean move(Action action) {
        System.out.println("Стена " + height + " м. высоты!");
        action.jump();
        if (action.getJumpHeight() >= height) {
            System.out.println("Высота взята");
            return true;
        } else {
            System.out.println("Не перепрыгнул");
            return false;
        }
    }
}
