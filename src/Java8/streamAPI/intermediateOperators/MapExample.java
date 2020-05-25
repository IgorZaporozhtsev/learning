package Java8.streamAPI.intermediateOperators;

import java.util.stream.Stream;

public class MapExample {
    public static void main(String[] args) {
        Stream.of("10", "11", "32")
                        .map(x -> Integer.parseInt(x, 16))
                        .forEach(System.out::println); //, , ,50
    }
}
