package lesson3.HomeWork3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Words {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> words = new HashMap<>();
        Scanner sc = new Scanner(new File("src/main/java/lesson3/HomeWork3/words.txt"));
        while (sc.hasNext()){
            String s = sc.next().trim();
            if (words.isEmpty()) {
                words.put(s, 1);
                continue;
            }
            if (words.containsKey(s)) {
                int counter = words.get(s);
                words.put(s, ++counter);
            }
            else words.put(s, 1);
        }
        //System.out.println(words);

        //words.forEach((key, value) -> System.out.println(key + " - " + value));

        //words.entrySet()
        // .forEach(ent -> System.out.println(ent.getKey() + " - " + ent.getValue()));
        words.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())/*Comparator.comparingInt(o -> -o.getValue())*/)
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}
