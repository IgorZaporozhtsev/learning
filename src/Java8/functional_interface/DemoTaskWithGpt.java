package Java8.functional_interface;


import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.Function;

public class DemoTaskWithGpt {
    public static void main(String[] args) throws IOException {
        Function<String, String> toUpperCaseFunction = String::toUpperCase;
        BiFunction<String, Integer, String> repeat = String::repeat;
        BiFunction<String, Integer, String> fun = repeat.andThen(toUpperCaseFunction);

        System.out.println(fun.apply("Java!", 4));

    }
}


