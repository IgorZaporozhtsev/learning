package JavaCore.collection.map;

import java.util.HashMap;
import java.util.Objects;

public class MutableObjectAsKey {

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableObjectAsKey person = (MutableObjectAsKey) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        var map = new HashMap<MutableObjectAsKey, String>(2);
        var person = new MutableObjectAsKey();
        //retrieve1(map, person);
        retrieve2(map, person);
    }

    //put obj with one hashcode but try retrieve object with another hashcode
    private static void retrieve1(HashMap<MutableObjectAsKey, String> map, MutableObjectAsKey person) {

        person.name = "Justin";
        System.out.println(person.name + " hashCode is: " + person.hashCode());
        map.put(person, "old Person"); //calculate hashcode of person
        person.name = "Richard";
        System.out.println(person.name + " hashCode is: " + person.hashCode());

        var retriedPerson = map.get(person);
        System.out.println("retrieved person is:  " + retriedPerson);
    }

    //put twice to map with different hashcode (same like in method retrieve1)
    private static void retrieve2(HashMap<MutableObjectAsKey, String> map, MutableObjectAsKey person) {
        person.name = "Justin";
        map.put(person, "old Person");
        person.name = "Richard";

        map.put(person, "new Person");
        var pers = map.get(person);
        System.out.println("retrieved person is: " + pers); //old Person is noo accessible by key
        System.out.println("map size " + map.size());
    }
}
