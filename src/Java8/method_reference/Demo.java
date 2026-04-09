package Java8.method_reference;

import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class Demo {
	/**
	 * See use case with Object::instanceMethodName {@link AccessControlService#getAvailableResources}
	 * */
    public static void main(String[] args) {
	    User user = new User(19);

	    //2. Reference to an instance method of a particular object
	    Predicate<User> predicate1 = u-> user.isAdult(u);//lambda
	    Predicate<User> predicate2 = user::isAdult;//method reference

	    //use-case use for comparison
	    // admin — фіксований receiver(одержувач), кожен user зі стріму — аргумент
	    // має сенс тільки якщо логіка залежить від стану receiver'а:
	    //instance::method потрібен коли метод використовує this (стан конкретного об'єкта тобто receiver'а)

	    List<User> users = List.of(new User(15), new User(25), new User(17));
	    User admin = new User(14);
	    List<User> youngers = users.stream()
		    .filter(admin::isYoungerThan) // Якщо true → залишаємо в результаті, якщо false → відкидаємо.
		    .toList();

	    //3. Reference to an instance method of an arbitrary object of a particular type
	    Predicate<User> predicate3 = user1 -> user1.isAdult(); //lambda
	    Predicate<User> predicate4 = User::isAdult; //передаш мені юзера потім як this у реалізації lambda
	    Predicate<User> isReadyToWorkPredicate = u -> u.isReadyToWork(21); //can not use method reference, cause signature different with Predicate#test

        boolean isAdult = predicate3.test(user);

	    // Predicate<User> //how it works: you passed me stream of user instances then filter out each user by calling isAdult with type User
	    //User u -> u.isAdult() - Java підставляє кожен елемент стріму (u) як this для методу isAdult().

	    //use-case filter
	    List<User> adultsMR2 = Stream.of(user)
		    .filter(User::isAdult) // Якщо true → залишаємо в результаті, якщо false → відкидаємо.
		    .toList();


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



