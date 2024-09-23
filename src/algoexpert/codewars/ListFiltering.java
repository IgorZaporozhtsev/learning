package algoexpert.codewars;

import Java8.functional_interface.predicate.PredicateTest;

import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;

public class ListFiltering {
    //https://www.codewars.com/kata/53dbd5315a3c69eed20002dd/train/java
    public static void main(String[] args) {
        List<Object> list = List.of(1, 2, "a", "b");
        System.out.println(filterList(list));
    }

    public static List<Object> filterList(final List<Object> list) {
        // Return the List with the Strings filtered out
        return list.stream()
                .filter(Predicate.not(item-> item instanceof String))
                .toList();
    }
}
