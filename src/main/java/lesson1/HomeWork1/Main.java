package lesson1.HomeWork1;

import java.util.Random;

public class Main {

    public static Random rnd = new Random();

    public static void main(String[] args) {
        Action[] actions = new Action[]{
                new Human(),
                new Cat(),
                new Robot()
        };
        Trainer[] trainers = new Trainer[4];
        for (int i = 0; i < trainers.length; i++) {
            if (rnd.nextBoolean()) trainers[i] = new Wall();
            else trainers[i] = new Track();
        }

        System.out.println("Начинаем забег с припятствиями!!");

        boolean flag;
        for (Action action : actions) {
            for (Trainer trainer : trainers) {
                flag = trainer.move(action);
                if (!flag) break;
                System.out.println("бежим дальше");
            }
        }
    }
}
