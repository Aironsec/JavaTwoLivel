package lesson1.HomeWork1;

import static lesson1.HomeWork1.Main.rnd;

public class Robot implements Action {
    private final double jumpHeight = 0;
    private final double runLength = (double) rnd.nextInt(100000) / 10;

    @Override
    public void run() {
        System.out.println("Робот бежит " + runLength + "м.");
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгает на " + jumpHeight + "м.");
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
