package Java8.pluralsight_courses.FromCollectionstoStreamsinJava8UsingLambdaExpressions.comparator;

import Java8.pluralsight_courses.FromCollectionstoStreamsinJava8UsingLambdaExpressions.Person_1;

public class MainComparator {
    public static void main(String[] args) {

        Person_1 nick = new Person_1("Nick", "Robinsin", 13);
        Person_1 dick = new Person_1("Dick", "semers", 17);

        Comparator<Person_1> cmpAge = (p1, p2) -> p1.getAge() - p2.getAge();
        Comparator<Person_1> cmpFirstName = (p1, p2) -> p1.getFirst_name().compareTo(p2.getFirst_name());

        int compare = cmpFirstName.compare(nick, dick);
        System.out.println(compare);


        //Because a single char can be converted to a Unicode value
        // and can be easily stored as integer taking up less space than a single character string.
        char c1 = 'a';
        char c2 = 'b';
        int i = c1 - c2;
        System.out.println(i);
    }
}
