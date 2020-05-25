package Java8.streamAPI.intermediateOperators;

import java.util.stream.IntStream;

public class FilterExample {
    //
    public static void main(String[] args) {
        IntStream.range(2, 9) //береться диапазон от 2 до 9 не включая 9
                .filter(x -> x % 3 == 0)
                .forEach(System.out::println);// 3, 6
    }
}
