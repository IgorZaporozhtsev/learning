package Java8.streamAPI.flatmap;

import java.util.Collection;
import java.util.List;

public class MainFlatMap {
    public static void main(String[] args) {
        List<List<String>> listOfLists = List.of(
            List.of("foo", "bar", "baz"),
            List.of("Java", "Kotlin", "Groovy"),
            List.of("Hello", "Good Bye")
        );

        System.out.println(
            listOfLists.stream()
                .flatMap(Collection::stream)
                .peek(System.out::println)
                .anyMatch("Java"::equals));
    }
}
