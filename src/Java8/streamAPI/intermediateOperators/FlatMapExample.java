package Java8.streamAPI.intermediateOperators;

import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6)
                .flatMap(x -> {
                    switch (x % 3) {
                        case 0:
                            return Stream.of(x, x * x,  x* x * 2 );
                        case 1:
                            return Stream.of(x);
                        case 2:
                        default:
                            return Stream.empty();
                    }
                })
                .forEach(System.out::println);// 1, 3, 9, 18, 4, 6, 36, 72

    }
}
