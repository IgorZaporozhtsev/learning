package algoexpert.codewars;

import java.util.concurrent.ThreadLocalRandom;

public class ThinkingAndTesting {
    public static void main(String[] args) {
        System.out.println(testTrueFalse(9));
    }



    public static int testTrueFalse(int n) {
        return Integer.bitCount(n);
    }
}
