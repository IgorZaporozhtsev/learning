package collections.Sortirofka;

import java.util.*;

class Person implements Comparable<Person> {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person p) {
        //return this.age - p.age;
        return this.name.compareTo(p.name); //сортировка по алфавиту
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Set set = new TreeSet();    // TreeSet -  эта коллекция самосартирующая
        set.add(new Person(43, "Tom"));
        set.add(new Person(32, "Baboon"));
        set.add(new Person(23, "Albatross"));
        set.add(new Person(44, "Snake"));

        for (Object o : set) {
            System.out.println(o);
        }
    }


}
