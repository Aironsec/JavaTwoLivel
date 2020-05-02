package lesson5.HomeWork5;

import java.util.Arrays;

public class ThreadTime {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    static float[] arr() {
        float[] m = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            m[i] = 1;
        }
        return m;
    }

    static long meted1(float[] arr) {
        long t = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return System.currentTimeMillis() - t;
    }

    static long meted2(float[] arr) throws InterruptedException {
        long t = System.currentTimeMillis();

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread th1 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Превая половина");
        });
        Thread th2 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Вторая половина");
        });
        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        return System.currentTimeMillis() - t;
    }

    public static void main(String[] args) {
        new Thread(() ->
                System.out.println("Превый метод выполнился за: " + meted1(arr()) + "мс."))
                .start();
        new Thread(() ->
        {
            try {
                System.out.println("Второй метод выполнился за: " + meted2(arr()) + "мс.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })
                .start();
    }
}
