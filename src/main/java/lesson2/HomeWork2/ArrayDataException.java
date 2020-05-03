package lesson2.HomeWork2;

public class ArrayDataException extends RuntimeException{
    public ArrayDataException(String str, int i, int j){
        super("Невозможно преобразовать \"" + str + "\" в ячецке массива (" + i + ", " + j + ")");
    }
}
