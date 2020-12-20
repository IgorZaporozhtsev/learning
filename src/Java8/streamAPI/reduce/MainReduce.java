package Java8.streamAPI.reduce;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainReduce {
    public static void main(String[] args) {

        BigInteger factorial = IntStream.rangeClosed(1, 3)
            .mapToObj(BigInteger::valueOf)
            .reduce(BigInteger.ONE, BigInteger::multiply);

        System.out.println(factorial);

        Stream<String> wordsStream = Stream.of("мама", "мыла", "раму");
        Optional<String> sentence = wordsStream.reduce((x, y) -> x + " " + y);
        System.out.println(sentence.orElse("empty"));
    }
}
