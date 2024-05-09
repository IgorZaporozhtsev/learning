package IO.parse_json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainParseStringIO {

    public static void main(String[] args) {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                long count = reader.lines()
                        .map(Person::toPerson)
                        .flatMap(Collection::stream)
                        .filter(person -> person.getAge() >= 50)
                        .count();


                System.out.println(count);
            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }
    }
}

class Person {
    String key;
    int age;

    public Person(int age) {
        this.age = age;
    }

    public static List<Person> toPerson(String string) {
        List<Person> people = new ArrayList<>();

        String[] entries = string.replaceAll("\\{|\\}", "").split(", ");

        for (String entry : entries) {
            String age = "";
            if (entry.contains("age")) {
                age = entry.split("=")[1];
                if (age.equals("5\"")) {
                    age = age.substring(0, age.length() - 1);

                }
                people.add(new Person(Integer.parseInt(age)));
            }
        }
        return people;
    }

    public String getKey() {
        return key;
    }

    public int getAge() {
        return age;
    }
}
