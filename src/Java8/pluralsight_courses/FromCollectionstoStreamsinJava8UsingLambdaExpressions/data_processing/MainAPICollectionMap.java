package Java8.pluralsight_courses.FromCollectionstoStreamsinJava8UsingLambdaExpressions.data_processing;

import Java8.pluralsight_courses.City;
import Java8.pluralsight_courses.ImplementingDesignPatternsUsingJava8Lambda.comparator.Person;
import util.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<City, List<Person>> firstGroup = new HashMap<>();
        firstGroup.putIfAbsent(paris, new ArrayList<>());
        firstGroup.get(paris).add(person1);

        firstGroup.computeIfAbsent(vancouver, city -> new ArrayList<>()).add(person2);
        firstGroup.computeIfAbsent(vancouver, city -> new ArrayList<>()).add(person3);

        System.out.println("---------------------------------------------- Map 1");
        PrintUtil.printMapOfList(firstGroup);

        Map<City, List<Person>> secondGroup = new HashMap<>();

        secondGroup.computeIfAbsent(vancouver, city -> new ArrayList<>()).add(person1);
        secondGroup.computeIfAbsent(london, city -> new ArrayList<>()).add(person2);
        secondGroup.computeIfAbsent(london, city -> new ArrayList<>()).add(person3);

        System.out.println("---------------------------------------------- Map 2");
        PrintUtil.printMapOfList(secondGroup);

        Map<City, List<Person>> thirdGroup = new HashMap<>();

        thirdGroup.computeIfAbsent(vancouver, city -> new ArrayList<>()).add(person1);
        thirdGroup.computeIfAbsent(london, city -> new ArrayList<>()).add(person2);
        thirdGroup.computeIfAbsent(london, city -> new ArrayList<>()).add(person3);

        System.out.println("----------------------------------------------- Map 3");
        PrintUtil.printMapOfList(thirdGroup);

        thirdGroup.forEach((city, people) ->
                secondGroup.merge(city, people, (people1, people2) -> {
                    people1.addAll(people2);
                    return people1;
                })
        );

        System.out.println("-------------------------------------------- Merged Map 2 and Map 3");
        PrintUtil.printMapOfList(secondGroup);

    }
}
