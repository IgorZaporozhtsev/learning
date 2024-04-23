package Java8.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class GFG {
    public static void main(String[] args) {
        // create a collection of an array of names
        // also contains nulls
        String[] strings = { "aman", "suvam", null,"sahil", null };

        // print the array
        System.out.println("Before sorting: " + Arrays.toString(strings));

        // apply nullsLast  method
        // and sort the array
        Arrays.sort(strings,Comparator.nullsLast(Comparator.naturalOrder()));

        // print the array
        System.out.println("After sorting: " + Arrays.toString(strings));
    }
}

