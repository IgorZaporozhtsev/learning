package JavaCore.collection.treeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @see <a href="https://javarush.com/groups/posts/2584-osobennosti-treemap">TreeMap example source</a>
 */
public class TreeMapExample {
    /**
     * Представь, что мы работаем в маркетинговом отделе большой компании, и у нас есть база людей, которым мы хотим показывать рекламу.
     * При этом есть два нюанса:
     * нам нужно вести учет количества показов каждому человеку;
     * алгоритм показа рекламы для несовершеннолетних отличается.
     * */
    public static void main(String[] args) {
        TreeMap<Person, Integer> map = new TreeMap<>(Comparator.comparingInt(o -> o.age));
        map.put(new Person("John", "Smith", 17), 2);
        map.put(new Person("Ivan", "Petrenko", 65), 120);
        map.put(new Person("Pedro", "Escobar", 32), 32);
        map.put(new Person("Radion", "Pyatkin", 14), 653);
        map.put(new Person("Sergey", "Vashkevich", 19), 234);

        Person firstAdultPerson = map.navigableKeySet().stream().filter(person -> person.age > 18).findFirst().get();

        Map<Person, Integer> youngPeopleMap = map.headMap(firstAdultPerson, false);
        Map<Person, Integer> adultPeopleMap = map.tailMap(firstAdultPerson, true);
        showAdvertisementToYoung(youngPeopleMap);
        showAdvertisementToAdult(adultPeopleMap);
    }

    public static void showAdvertisementToYoung(Map map){

    }
    public static void showAdvertisementToAdult(Map map){

    }

}


class Person {
    public String firstName;
    public String lastName;
    public int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}