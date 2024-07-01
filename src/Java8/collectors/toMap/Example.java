package Java8.collectors.toMap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> result = collectToMap(list);
        System.out.println(result);
    }


    private static Map<String, Long> collectToMap(List<String> list) {
        Map<String, Long> collect = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        LinkedHashMap<String, Long> collect1 = collect
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
        return collect1;
    }

}