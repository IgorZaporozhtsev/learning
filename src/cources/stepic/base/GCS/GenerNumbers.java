package cources.stepic.base.GCS;

import java.util.stream.IntStream;

public class GenerNumbers {
    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            pseudoRandomStream(30).mapToObj(x -> " " + x).forEachOrdered(System.out::print);
            System.out.println();
        }
    }


    public static IntStream pseudoRandomStream(int seed) {

        return IntStream.iterate(seed, operand ->  (operand * operand/10) % 1000 );
    }
}
