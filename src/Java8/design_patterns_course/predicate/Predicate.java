package Java8.design_patterns_course.predicate;

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
