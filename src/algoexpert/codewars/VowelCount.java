package algoexpert.codewars;

import java.util.HashMap;
import java.util.Map;

public class VowelCount {
    public static void main(String[] args) {
        int count = getCount("abracadabra");
        System.out.println(count);
    }

    public static int getCount(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put( 'e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);

        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            map.computeIfPresent(c, (k,v) -> v + 1);
        }
        long count = map.values().stream()
                .reduce(0, Integer::sum);

        return (int) count;
    }

}
