package Java8.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorNullLast {
    public static void main(String[] args) {
        // create some user objects
        User u1 = new User("Aaman", 25);
        User u2 = new User("Joyita", 22);
        User u3 = new User("Suvam", 28);
        User u4 = new User("mahafuj", 25);

        System.out.println("One null Objects");
        List<User> list = Arrays.asList(u1, u2, u3, null, u4);

        Collections.sort(list, Comparator.nullsLast(Comparator.comparing(User::getName)));

        list.forEach(System.out::println);

        System.out.println("\nMore than One null Objects");

        list = Arrays.asList(u1, u4, null, u2, u3, null, null);

        Collections.sort(list, Comparator.nullsLast(Comparator.comparing(User::getName)));

        list.forEach(System.out::println);
    }
}

class User implements Comparable<User> {
    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(User u1) {
        return name.compareTo(u1.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }

}
