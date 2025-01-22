package Java8.method_referevce;

import Java8.pluralsight_courses.FromCollectionstoStreamsinJava8UsingLambdaExpressions.comparator.Comparator;

import java.io.IOException;
import java.util.function.*;

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

        //Reference to an Instance Method of a Particular Object
        Supplier<Integer> ageSupplier = user::getAge;
        ageSupplier.get();

        //Reference to an Instance Method of an Arbitrary Object of a Particular Type
        Function<User, Integer> ageFunction = User::getAge;
        ageFunction.apply(new User(23));

        BiFunction<User, User, Integer> ageBiFun = User::getMiddleAge;
        Integer middleAge = ageBiFun.apply(new User(12), new User(43));
        System.out.println("middleAge: " + middleAge);


        String hello = "Hello";
        UnaryOperator<String> upperFunction = String::toUpperCase; //this
        upperFunction.apply("Hello");// this
        Supplier<String> upperFunction2 = hello::toUpperCase;


        Function<Integer, String> helloSubstringFunction = hello::substring;
        String helloSub = helloSubstringFunction.apply(1);
        System.out.println(helloSub); //"ello"

        BiFunction<String, Integer, String> helloBiFun = String::substring; ///this first parameter
        String helloSuBi = helloBiFun.apply("Hello", 1);
        System.out.println(helloSuBi); //"ello"


    }
}

class User{
    private final int age;

    public User(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public int getMiddleAge(User user){
        return this.getAge() + user.getAge() /2;
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



