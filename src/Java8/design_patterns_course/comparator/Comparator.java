package Java8.design_patterns_course.comparator;

import Java8.design_patterns_course.function.Function;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1, T t2);

    static Comparator<Person> comparing(Function<Person, String> keyExtractor) {
        Objects.requireNonNull(keyExtractor);

        Comparator<Person> comparator = (t1, t2) -> keyExtractor.apply(t1).compareTo(keyExtractor.apply(t2));

        return comparator;
    }
}
