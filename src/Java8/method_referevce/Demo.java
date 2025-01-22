package Java8.method_referevce;

import Java8.pluralsight_courses.FromCollectionstoStreamsinJava8UsingLambdaExpressions.comparator.Comparator;

import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Demo {

    public static void main(String[] args) {
        User user = new User(19);


        Predicate<User> isAdultPredicate2 = user::isAdult; //user pass as method argument

        //User#isAdult has same signature with Predicate#test
        Predicate<User> isAdultPredicate = User::isAdult; //can use method reference
        Predicate<User> isReadyToWorkPredicate = u -> u.isReadyToWork(21); //can not use method reference, cause signature different with Predicate#test


        boolean isAdult = isAdultPredicate.test(user);
        boolean isReadyToWork = isReadyToWorkPredicate.test(user);

        System.out.println(isAdult);
        System.out.println(isReadyToWork);

        foo();

    }

    public static void foo() {
        User user = new User(19);

        //Reference to an Instance Method of an Arbitrary Object of a Particular Type
        //Function<User, User> functionArbitrary = User::compareTo;
        //System.out.println(functionArbitrary.apply(23));

        //Reference to an Instance Method of a Particular Object
        Function<User, Integer> functionInstanceMethod = user1 -> user.getAverageInstanceMethod(user1); //user::getAverageInstanceMethod;
        System.out.println(functionInstanceMethod.apply(user));


        Integer number = 1;
        Function<Integer, Integer> funInt = number::compareTo;
        funInt.apply(2);

        Comparator<Integer> integerComparator = Integer::compareTo;
        System.out.println(integerComparator.compare(1, 2));


        String hello = "Hello";
        UnaryOperator<String> upperFunction = String::toUpperCase; //this
        upperFunction.apply("Hello");// this
        //UnaryOperator<String> upperFunction2 = hello::toUpperCase;


        Function<Integer, String> helloSubstringFunction = hello::substring;
        String helloSub = helloSubstringFunction.apply(1);
        System.out.println(helloSub); //"ello"

        BiFunction<String, Integer, String> helloBiFun = String::substring;
        String helloSuBi = helloBiFun.apply("Hello", 1);
        System.out.println(helloSuBi); //"ello"


    }
}

class User{
    private final int age;

    public User(int age) {
        this.age = age;
    }

    public int getAge(int age) {
        return age;
    }

    public User compareTo(User anotherInteger){
        return new User(43);
    }

    public int getAge() {
        return age;
    }

    public int getAverageInstanceMethod(User user){
        return user.getAge();
    }

    public boolean isAdult(){
        return age > 18;
    }

    public boolean isReadyToWork(int age){
        return age > 21;
    }

    public boolean isAdult(User user) {
        return user.getAge() < 18;
    }
}



