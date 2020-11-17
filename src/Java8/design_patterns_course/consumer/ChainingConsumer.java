package Java8.design_patterns_course.consumer;

public class ChainingConsumer {
    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println("c1 = " + s);
        Consumer<String> c2 = s -> System.out.println("c1 = " + s);


        // 1st approach

        Consumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };

        c3.accept("Hello");

        // 2nd crate andThen

        Consumer<String> c4 = c1.andThen(c2);
        c4.accept("Hi");

    }
}
