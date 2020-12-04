package Java8.pluralsight_courses.ImplementingDesignPatternsUsingJava8Lambda.function;

public class FunctionIdentity {
    public static void main(String[] args) {
        Function<String, String> identity = Function.identity();
    }
}
