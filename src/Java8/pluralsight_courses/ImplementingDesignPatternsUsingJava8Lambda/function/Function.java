package Java8.pluralsight_courses.ImplementingDesignPatternsUsingJava8Lambda.function;

import java.io.IOException;
import java.util.Objects;

@FunctionalInterface
public interface Function<T/*Meteo*/, R/*Integer*/> {
    R apply(T t) throws IOException;

    default <V> Function<T/*Meteo*/, V/*Double*/> andThen(Function<R/*Integer*/, V/*Double*/> next) {
        Objects.requireNonNull(next);

        return t -> {
            R r = this.apply(t);
            return next.apply(r);
        };
    }

    default <V> Function<V/*Meteo*/, R/*Double*/> compose(Function<V/*Meteo*/, T/*Integer*/> next) {
        Objects.requireNonNull(next);

        return v -> {
            T t = next.apply(v);
            return this.apply(t);
        };
    }

    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
