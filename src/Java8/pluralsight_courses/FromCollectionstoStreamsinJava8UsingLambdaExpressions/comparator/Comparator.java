package Java8.pluralsight_courses.FromCollectionstoStreamsinJava8UsingLambdaExpressions.comparator;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T t1, T t2);
}
