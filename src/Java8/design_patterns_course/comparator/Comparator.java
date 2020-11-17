package Java8.design_patterns_course.comparator;

import Java8.design_patterns_course.function.Function;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T t1, T t2);

    static Comparator<Person> comparing(Function<Person, String> keyExtractor) {
        Objects.requireNonNull(keyExtractor);

        return (p1, p2) -> {
            String s1 = keyExtractor.apply(p1);
            String s2 = keyExtractor.apply(p2);
            return s1.compareTo(s2);
        };
    }
}
