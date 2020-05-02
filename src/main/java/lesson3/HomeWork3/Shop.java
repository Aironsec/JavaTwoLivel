package lesson3.HomeWork3;

import java.util.Scanner;
import java.util.TreeMap;

public class Shop {
    public static void main(String[] args) {
        TreeMap<String, TreeMap<String, Integer>> inputData = new TreeMap<>();
        String str = "Милла Йовович томаты 300\n" +
                "Анна Панкратова йогурт 37\n" +
                "Сурикат ИзМадагаскара трава 37\n" +
                "Анна Панкратова молоко 40\n" +
                "Анна Панкратова сухарики 23\n" +
                "Панкратова Анна новыйюзер 30";
        Scanner sc = new Scanner(str);
        while (sc.hasNext()) {
            String inUser = sc.next() + " " + sc.next();
            String inProduct = sc.next();
            Integer inCost = sc.nextInt();
            if (inputData.containsKey(inUser))
                inputData.get(inUser).put(inProduct, inCost);
            else {
                TreeMap<String, Integer> product = new TreeMap<>();
                product.put(inProduct, inCost);
                inputData.put(inUser, product);
            }
        }
        //System.out.println(inputData);
        inputData.forEach((k, v) ->{
            System.out.println(k + ":");
            v.forEach((kk, vv) -> System.out.println("    " + kk + " " + vv));
        });

    }

}
