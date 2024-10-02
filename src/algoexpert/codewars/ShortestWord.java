package algoexpert.codewars;

import java.util.Arrays;
import java.util.Optional;

public class ShortestWord {
    public static void main(String[] args) {
        System.out.println(findShort("bitcoin take over the world maybe who knows perh"));

    }

    private static int findShort(String s) {
        String[] split = s.split("\\s");
        Integer i = Arrays.stream(split)
                .map(String::length)
                .min(Integer::compareTo)
                .get();

        return i;
    }
}
