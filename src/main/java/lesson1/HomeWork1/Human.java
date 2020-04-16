package lesson1.HomeWork1;

import static lesson1.HomeWork1.Main.rnd;

public class Human implements Action {
    private final double jumpHeight = (double) rnd.nextInt(25) / 10;
    private final double runLength = (double) rnd.nextInt(100000) / 10;

    @Override
    public void run() {
        System.out.println("Человек бежит " + runLength + "м.");
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгает на " + jumpHeight + "м.");
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
