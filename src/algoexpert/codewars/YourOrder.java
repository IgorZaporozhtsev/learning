package algoexpert.codewars;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YourOrder {
    public static void main(String[] args) {
        System.out.println(order("is2 Thi1s T4est 3a"));
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
                .sorted(Map.Entry.comparingByKey())
                .toList();


        return list.stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(" "));
    }
}