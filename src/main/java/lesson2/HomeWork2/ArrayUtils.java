package lesson2.HomeWork2;

public class ArrayUtils {
    public long arraySum(Object[][] array) {
        if (array.length != 4) {
            throw new ArraySizeException();
        }
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) {
                throw new ArraySizeException();
            }
        }
        long sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String str = array[i][j].toString().trim();
                for (int k = 0; k < str.length(); k++) {
                    if (str.charAt(k) < '0' || str.charAt(k) > '9')
                        throw new ArrayDataException(str, i, j);
                }
                sum += Integer.parseInt(array[i][j].toString().trim());
            }
        }
        return sum;
    }
}
