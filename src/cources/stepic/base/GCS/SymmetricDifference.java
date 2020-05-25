package cources.stepic.base.GCS;



import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {

    }


    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> first = new HashSet<T>(set1);
        Set<T> second = new HashSet<T>(set2);
        first.removeAll(second); // осталась 3

        Set<T> first1 = new HashSet<T>(set1);
        Set<T> second2 = new HashSet<T>(set2);
        second2.removeAll(first1); // осталась 0

        Set<T> all = new HashSet<T>();
        all.addAll(first);
        all.addAll(second2);
        return all;



    }
}
