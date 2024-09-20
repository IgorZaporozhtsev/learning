package algoexpert.codewars;

import Java8.pluralsight_courses.ImplementingDesignPatternsUsingJava8Lambda.function.Function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DescendingOrder {
    //https://www.codewars.com/kata/5467e4d82edf8bbf40000155/train/java

    public static void main(String[] args) {
        System.out.println(sortDesc(42145));
    }
    public static int sortDesc(final int num) {
        //Your code
        String s = String.valueOf(num);
        String[] split = s.split("");

        List<Integer> list = Arrays.stream(split)
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder()).toList();

        String max = list.stream()
                .map(String::valueOf).collect(Collectors.joining());
        return Integer.parseInt(max);
    }
}
