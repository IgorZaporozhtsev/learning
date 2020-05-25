package Java8.streamAPI.intermediateOperators;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortedExample {
    public static void main(String[] args) {
        Stream.of(120, 410, 85, 32, 314, 12)
                .sorted(Comparator.naturalOrder())
    .forEach(System.out::println);
    }
}
