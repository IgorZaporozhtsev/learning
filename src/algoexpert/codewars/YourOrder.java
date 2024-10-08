package algoexpert.codewars;

import java.util.*;
import java.util.stream.Collectors;

public class YourOrder {
    public static void main(String[] args) {
        System.out.println(order2("is2 Thi1s T4est 3a"));
    }


    public static String order(String words) {
        if (words.isEmpty()) return "";

        //1. define the number
        String[] strs = words.split("\\s");
        Map<Integer, String> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                if (Character.isDigit(c)) {
                    int digit = Integer.parseInt(String.valueOf(c));
                    map.put(digit, str);
                }
            }
        }

        List<Map.Entry<Integer, String>> list = map.entrySet().stream()
                //(c1, c2) -> c1.getKey().compareTo(c2.getKey()
                //Comparator.comparing(Map.Entry::getKey)
                .sorted(Map.Entry.comparingByKey())
                .toList();


        return list.stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(" "));
    }

    public static String order2(String words){
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
                .reduce((a, b) -> a + " " + b).get();
    }
}