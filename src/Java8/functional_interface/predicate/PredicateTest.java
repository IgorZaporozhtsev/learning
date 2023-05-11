package Java8.functional_interface.predicate;

import java.util.ArrayList;
import java.util.List;

/**
* Java 8 in Action page #50
* */

public class PredicateTest {
    public static void main(String[] args) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("string_1");
        listOfStrings.add("string_2");
        listOfStrings.add("");
        listOfStrings.add("string_4");
        listOfStrings.add("");

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        //List<String> nonEmpty = filter(listOfStrings, (String s) -> !s.isEmpty()); // in this way we can pass lambda in method too
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);

        System.out.println(nonEmpty);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T s: list){
            if(p.test(s)){
                results.add(s);
            }
        }
        return results;
    }

    @FunctionalInterface
    public interface Predicate<T>{
        boolean test(T t);
    }
}
