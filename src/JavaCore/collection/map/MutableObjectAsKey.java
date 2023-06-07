package JavaCore.collection.map;


import java.util.HashMap;
import java.util.Objects;

public class MutableObjectAsKey {

    private String name;

    public MutableObjectAsKey() {
    }

    public MutableObjectAsKey(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableObjectAsKey person = (MutableObjectAsKey) o;
        return Objects.equals(name, person.name);
    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        var map = new HashMap<MutableObjectAsKey, String>(2);
        //sameHash(map);
        //withoutOwnEqHash(map);
        //retriveMutableWithNotExistedHasCode(map);
        tryRetrieveAbandoneMutableObject(map);
    }

   //if we don't have same hashcode, Node go to same index. It calls collision
    private static void sameHash(HashMap<MutableObjectAsKey, String> map){
      /* @Override
        public int hashCode() {
            return 1;
        }*/

        var person1 = new MutableObjectAsKey("Person1"); System.out.println(person1.name + " hashCode is: " + person1.hashCode());
        var person2 = new MutableObjectAsKey("Person1"); System.out.println(person2.name + " hashCode is: " + person2.hashCode());
        map.put(person1, "Person 1");
        map.put(person2, "Person 1");


        var pers = map.get(person1);
        System.out.println("retrieved person is: " + pers); //old Person is noo accessible by key
        System.out.println("Map hold " + map.size() + " persons");
    }

    //if we don't have own eq and hashcode, Object#hasCode() provide native impl
    private static void withoutOwnEqHash(HashMap<MutableObjectAsKey, String> map){
        var person1 = new MutableObjectAsKey("Person1"); System.out.println(person1.name + " hashCode is: " + person1.hashCode());
        var person2 = new MutableObjectAsKey("Person1"); System.out.println(person2.name + " hashCode is: " + person2.hashCode());
        map.put(person1, "Person 1");

        var pers = map.get(person2);
        System.out.println("retrieved person is: " + pers); //is Null because we have different hashCode
        System.out.println("Map hold " + map.size() + " persons");
    }

    //put obj with one hashcode, change field of person
    private static void retriveMutableWithNotExistedHasCode(HashMap<MutableObjectAsKey, String> map ) {
        var person1 = new MutableObjectAsKey();
        person1.name = "Justin";
        System.out.println("Person 1 has name : " + person1.name + " hashCode is: " + person1.hashCode());
        map.put(person1, "old Person"); //calculate hashcode of person

        //set different name and expect other hashcode for object
        person1.name = "Richard";
        System.out.println("Person 1 has name : " + person1.name + " hashCode is: " + person1.hashCode());

        //try to retrieve person with no existed hashCode
        var retriedPerson = map.get(person1);
        System.out.println("retrieved person is:  " + retriedPerson);
        System.out.println("map size " + map.size());
    }

    //put twice to map with different hashcode// There is no Abandoned object we we REPLACE link to obj
    private static void tryRetrieveAbandoneMutableObject(HashMap<MutableObjectAsKey, String> map) {
        var person1 = new MutableObjectAsKey();
        person1.name = "Justin";
        System.out.println("Person 1 has name : " + person1.name + " hashCode is: " + person1.hashCode());


        //set different name, and put object one more time, old Person was Abandone
        map.put(person1, "old Person");

        person1.name = "Richard";
        System.out.println("Person 1 has name : " + person1.name + " hashCode is: " + person1.hashCode());
        map.put(person1, "new Person"); //we REPLACE link!!!

        var pers = map.get(person1);
        System.out.println("retrieved person is: " + pers);
        System.out.println("map size " + map.size());

        map.forEach((k, v) -> System.out.println("key - " + k + " : " + "value - " + v));

    }

}
