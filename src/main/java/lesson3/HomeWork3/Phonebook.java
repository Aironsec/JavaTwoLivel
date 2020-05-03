package lesson3.HomeWork3;

import java.util.HashSet;
import java.util.TreeMap;

public class Phonebook {
    private TreeMap<String, HashSet> phonebook;

    public Phonebook() {
        this.phonebook = new TreeMap<>();
    }

    public void add(String lastName, String number) {
        if (phonebook.containsKey(lastName)) phonebook.get(lastName).add(number);
        else {
            HashSet<String> hs = new HashSet<>();
            hs.add(number);
            phonebook.put(lastName.toLowerCase(), hs);
        }
    }

    public String get(String lastName) {
        if (phonebook.containsKey(lastName)) return phonebook.get(lastName).toString();
        else return "Такой человек не найден";
    }
}
