package algoexpert.codewars;

import com.sun.jdi.IntegerType;

import java.util.Arrays;
import java.util.OptionalInt;

public class HighestAndLowest {
    public static void main(String[] args) {
        System.out.println(highAndLow("1 2 3 4 5"));  // return "5 1"
        System.out.println(highAndLow("1 2 -3 4 5")); // return "5 -3"
        System.out.println(highAndLow("1 9 3 4 -5")); // return "9 -5"
    }

    public static String highAndLow(String numbers) {
        // Code here or
        String[] str = numbers.split(" ");
        int max = Arrays.stream(str)
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();

        int min = Arrays.stream(str)
                .mapToInt(Integer::parseInt)
                .min()
                .getAsInt();

        return String.valueOf(max)  +" "+ String.valueOf(min);
    }

}
