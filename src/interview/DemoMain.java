package interview;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DemoMain {
    public static void main(String[] args) {
        List<Integer> ints = IntStream.range(0, 10)
                .boxed()
                .toList();


        System.out.println(minMaxOddInts(ints));

    }

    static Map<String, Integer> minMaxOddInts(List<Integer> ints) {
        return ints.stream()
                .filter(it -> it % 2 != 0)
                .collect(Collectors.teeing(
                        Collectors.maxBy(Integer::compareTo),
                        Collectors.minBy(Integer::compareTo),
                        (maxOddInt, minOddInt) -> Map.of(
                                "MAX", maxOddInt.orElseThrow(),
                                "MIN", minOddInt.orElseThrow()
                                )
                        ));
    }
}
