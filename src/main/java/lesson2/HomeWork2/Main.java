package lesson2.HomeWork2;

public class Main {
    public static void main(String[] args) {
        String[][] s1 = new String[4][3];
        String[][] s2 = new String[4][4];
        String[][] s3 = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                s2[i][j] = "15";
                s3[i][j] = "15";
            }
        }
        s2[3][1] = "d";
        ArrayUtils arrSum = new ArrayUtils();
        System.out.println("Сумма массива = " + arrSum.arraySum(s1));
    }
}
