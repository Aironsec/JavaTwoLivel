package lesson2.HomeWork2;

public class ArraySizeException extends RuntimeException{
    public ArraySizeException() {
        super("Не верный размер массива. Ожидался 4х4");
    }
}
