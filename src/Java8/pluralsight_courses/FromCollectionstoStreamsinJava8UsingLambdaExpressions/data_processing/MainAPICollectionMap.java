package Java8.pluralsight_courses.FromCollectionstoStreamsinJava8UsingLambdaExpressions.data_processing;

import Java8.pluralsight_courses.City;
import Java8.pluralsight_courses.ImplementingDesignPatternsUsingJava8Lambda.comparator.Person;

import java.util.*;

public class MainAPICollectionMap {
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

        City paris = new City("Paris");
        City vancouver = new City("Vancouver");
        City london = new City("London");

        Map<City, List<Person>> map = new HashMap<>();
        map.putIfAbsent(paris, new ArrayList<>());
        map.get(paris).add(person1);

        map.computeIfAbsent(vancouver, city -> new ArrayList<>()).add(person2);
        map.computeIfAbsent(vancouver, city -> new ArrayList<>()).add(person3);


        System.out.println("People form Paris: " + map.getOrDefault(paris, Collections.emptyList()));
        System.out.println("People form Paris: " + map.getOrDefault(vancouver, Collections.emptyList()));


        Map<City, List<Person>> map1 = new HashMap<>();

        map1.computeIfAbsent(vancouver, city -> new ArrayList<>()).add(person1);
        map1.computeIfAbsent(london, city -> new ArrayList<>()).add(person2);
        map1.computeIfAbsent(london, city -> new ArrayList<>()).add(person3);

        System.out.println("Map 1");

        map1.forEach((city, people) -> System.out.println(city + " : " + people));


        Map<City, List<Person>> map2 = new HashMap<>();

        map2.computeIfAbsent(vancouver, city -> new ArrayList<>()).add(person1);
        map2.computeIfAbsent(london, city -> new ArrayList<>()).add(person2);
        map2.computeIfAbsent(london, city -> new ArrayList<>()).add(person3);

        System.out.println("Map 2");

        map2.forEach((city, people) -> System.out.println(city + " : " + people));

        map2.forEach(
            (city, people) -> {
                map1.merge(city, people, (people1, people2) -> {
                    people1.addAll(people2);
                    return people1;
                });
            }
        );

        System.out.println("Merged Map 1");
        map1.forEach(
            (city, people) -> System.out.println(city + ":" + people)
        );

    }
}
