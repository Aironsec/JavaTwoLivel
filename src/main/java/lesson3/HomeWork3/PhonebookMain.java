package lesson3.HomeWork3;

import java.util.HashMap;

public class PhonebookMain {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Петров", "(903)800-80-80");
        phonebook.add("Петров", "(903)801-81-81");
        phonebook.add("Петров", "(903)802-82-82");
        phonebook.add("Петров", "(903)802-82-82");

        phonebook.add("Сидоров", "(910)900-90-00)");
        phonebook.add("Сидоров", "(910)900-90-00)");

        System.out.println(phonebook.get("сидоров".toLowerCase()));
    }
}
