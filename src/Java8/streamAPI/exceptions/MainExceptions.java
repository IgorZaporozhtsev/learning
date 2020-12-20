package Java8.streamAPI.exceptions;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainExceptions {
    public static void main(String[] args) {
        Stream<BigInteger> bigIntegerStream = IntStream.rangeClosed(1, 3)
            .mapToObj(BigInteger::valueOf);

        BigInteger reduce = bigIntegerStream.reduce(BigInteger.ONE, BigInteger::multiply);

        System.out.println(reduce);

        bigIntegerStream.peek(System.out::println);
    }
}
