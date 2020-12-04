package Java8.pluralsight_courses.FromCollectionstoStreamsinJava8UsingLambdaExpressions.predicate;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        return t -> test(t) && other.test(t);
    }

    default Predicate<T> or(Predicate<T> other) {
        return t -> test(t) || other.test(t);
    }

    static <T> Predicate<T> isEqual(T t) {
        return s -> s.equals(t);
    }
}
