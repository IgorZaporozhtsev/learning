package books.ModernJavaInAction.behavior_parameterization.with_generics;

public interface Predicate<T> {
    boolean test(T t);
}
