package Java8.streamAPI.intermediateOperators;

import java.util.stream.IntStream;

public class SkipExample {
    public static void main(String[] args) {
        IntStream.range(0, 10)
                .limit(5)
                .skip(3)
                .forEach(System.out::println);//



        IntStream.range(0, 10)
                .skip(5)
                .limit(3)
                .skip(1)
                .forEach(System.out::println);



    }
}
