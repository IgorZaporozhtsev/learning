package collections.Sortirofka;//package collections.Sortirofka;
import java.util.*;


class Person2  {
    int age;
    String name;


    public Person2(int age, String name) {
        this.age = age;
        this.name = name;

    }



    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}



class ComparePerson implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        //return o1.age - o2.age;
        return o1.compareTo(o2);
    }

}

public class Main2 {
    public static void main(String[] args) {
        ComparePerson comparePerson = new ComparePerson();

        Set set = new TreeSet(comparePerson);    // TreeSet -  эта коллекция самосартирующая
        set.add(new Person(07, "Andre"));
        set.add(new Person(11, "Bob"));
        set.add(new Person(32, "Cliff"));
        set.add(new Person(04, "Den"));

        for (Object o : set) {
            System.out.println(o);
        }

        Set set1 = new HashSet();
        for (int i = 0; i < 100; i++) {
            set1.add(i);
        }

        //set1.stream().forEach(s -> System.out.println(s));

        System.out.println("\n");

        List list = new ArrayList();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        list.stream().forEach(s -> System.out.println(s));

    }




}