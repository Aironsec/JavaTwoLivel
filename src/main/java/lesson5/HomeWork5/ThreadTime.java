package lesson5.HomeWork5;

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

    static synchronized void meted1(float[] arr) {

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    synchronized static void meted2(float[] arr) {
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

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
    }

    public static void main(String[] args) {
        float[] arr1 = arr();
        float[] arr2 = arr();
        long t = System.currentTimeMillis();
        meted1(arr1);
        System.out.println("Превый метод выполнился за: " + (System.currentTimeMillis() - t) + "мс.");
        t = System.currentTimeMillis();
        meted2(arr2);
        System.out.println("Второй метод выполнился за: " + (System.currentTimeMillis() - t) + "мс.");

    }
}
