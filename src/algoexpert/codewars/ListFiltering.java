package algoexpert.codewars;

import java.io.Serializable;
import java.util.List;

public class ListFiltering {
    //https://www.codewars.com/kata/53dbd5315a3c69eed20002dd/train/java
    public static void main(String[] args) {
        List<Object> list = List.of(1, 2, "a", "b");
        System.out.println(filterList(list));
    }

    public static List<Object> filterList(final List<Object> list) {
        // Return the List with the Strings filtered out
        return list.stream()
                .filter(item -> !(item instanceof String))
                .toList();
    }
}
