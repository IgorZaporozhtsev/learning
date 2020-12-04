package Java8.pluralsight_courses.ImplementingDesignPatternsUsingJava8Lambda.predicate;

import java.util.Objects;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> andThen(Predicate<T> next) {
        Objects.requireNonNull(next);
        return t -> this.test(t) && next.test(t);
    }

    default Predicate<T> negate() {
        return t -> !this.test(t);
    }
}
