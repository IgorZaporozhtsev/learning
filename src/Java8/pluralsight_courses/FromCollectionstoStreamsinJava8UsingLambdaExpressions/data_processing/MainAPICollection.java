package Java8.pluralsight_courses.FromCollectionstoStreamsinJava8UsingLambdaExpressions.data_processing;

import Java8.pluralsight_courses.ImplementingDesignPatternsUsingJava8Lambda.comparator.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainAPICollection {
    public static void main(String[] args) {
        Person person1 = new Person("Erica", 12);
        Person person2 = new Person("Rick", 34);
        Person person3 = new Person("Sam", 12);
        Person person4 = new Person("Tom", 6);
        Person person5 = new Person("Richard", 54);
        Person person6 = new Person("Christopher", 24);
        Person person7 = new Person("David", 19);
        Person person8 = new Person("Albert", 10);
        Person person9 = new Person("Antonio", 12);
        Person person10 = new Person("Bob", 12);

        List<Person> people = new ArrayList<>(Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8, person9, person10));

        people.replaceAll(person -> new Person(person.getName().toUpperCase(), person.getAge()));

        people.sort(Comparator.comparing(Person::getName));//.thenComparing(Person::getName));

        people.removeIf(person -> person.getAge() < 10);

        people.forEach(System.out::println);

    }
}
