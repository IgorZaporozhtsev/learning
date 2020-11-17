package Java8.design_patterns_course.comparator;

public class PlayWithComparators {
    public static void main(String[] args) {
        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 32);

        Comparator<Person> cmpName = Comparator.comparing(Person::getName);

        boolean isMaryEqJohn = cmpName.compare(mary, john) > 0;
        boolean isJohnEqJames = cmpName.compare(john, james) > 0;
        boolean isLindaEqJohn = cmpName.compare(linda, john) > 0;

        System.out.println("Mary > John : " + isMaryEqJohn);
        System.out.println("John > James : " + isJohnEqJames);
        System.out.println("Linda > John : " + isLindaEqJohn);
    }


}
