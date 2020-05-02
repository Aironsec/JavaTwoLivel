package lesson1.HomeWork1;

import static lesson1.HomeWork1.Main.rnd;

public class Cat implements Action {
    private final double jumpHeight = (double) rnd.nextInt(10) / 10;
    private final double runLength = (double) rnd.nextInt(50000) / 10;

    @Override
    public void run() {
        System.out.println("Кот бежит " + runLength + "м.");
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгает на " + jumpHeight + "м.");
    }

    @Override
    public double getRunLength() {
        return runLength;
    }

    @Override
    public double getJumpHeight() {
        return jumpHeight;
    }

}
