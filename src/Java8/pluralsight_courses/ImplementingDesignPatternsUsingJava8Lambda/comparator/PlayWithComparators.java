package Java8.pluralsight_courses.ImplementingDesignPatternsUsingJava8Lambda.comparator;

import java.util.ArrayList;
import java.util.List;

public class PlayWithComparators {
    public static void main(String[] args) {
        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 32);

        List<Person> people = new ArrayList<>();
        people.add(mary);
        people.add(john);
        people.add(linda);
        people.add(james);

        //people.sort((Person p1, Person p2)-> p1.getName().compareTo(p2.getName()));
        //people.sort(java.util.Comparator.comparing(Person::getName));


        Comparator<Person> cmpByName = Comparator.comparing(Person::getName);
        //Comparator<Person> cmpByName = (p1, p2) -> p1.getAge() - p2.getAge();
        //Comparator<Person> cmpByName = (p1, p2) -> p1.getName().compareTo(p2.getName());


        int result1 = cmpByName.compare(mary, john);
        boolean isMaryEqJohn = result1 > 0;
        System.out.println("compare result: " + result1 + " then Mary > John: " + isMaryEqJohn);

        int result2 = cmpByName.compare(john, james);
        boolean isJohnEqJames = result2 > 0;
        System.out.println("compare result: " + result2 + " then John > James : " + isJohnEqJames);

        int result3 = cmpByName.compare(linda, john);
        boolean isLindaEqJohn = result3 > 0;
        System.out.println("compare result: " + result3 + " then Linda > John : " + isLindaEqJohn);
    }


}
