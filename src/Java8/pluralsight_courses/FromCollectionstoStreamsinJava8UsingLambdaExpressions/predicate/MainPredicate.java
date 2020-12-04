package Java8.pluralsight_courses.FromCollectionstoStreamsinJava8UsingLambdaExpressions.predicate;

public class MainPredicate {
    public static void main(String[] args) {
        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() > 5;

        Predicate<String> p3 = p1.and(p2);

        System.out.println("less 5 " + p3.test("yes"));
        System.out.println("between 5 - 20 " + p3.test("just congrat"));
        System.out.println("more than 20 " + p3.test("More thar 20 words I use here"));

        Predicate<String> p4 = p1.or(p2);

        System.out.println("less 5 " + p4.test("yes"));
        System.out.println("between 5 - 20 " + p4.test("just congrat"));
        System.out.println("more than 20 " + p4.test("More thar 20 words I use here"));

        Predicate<String> p5 = Predicate.isEqual("yes");

        System.out.println("less 5 " + p5.test("yes"));
        System.out.println("less 5 " + p5.test("no"));
    }
}
