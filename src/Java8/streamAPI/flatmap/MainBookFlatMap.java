package Java8.streamAPI.flatmap;

import java.util.*;
import java.util.stream.Collectors;

public class MainBookFlatMap {
    public static void main(String[] args) {

        Developer javaDeveloper = new Developer();
        javaDeveloper.addBook("Java 8 in Action");
        javaDeveloper.addBook("Spring Boot in Action");
        javaDeveloper.addBook("Effective Java (3nd Edition)");

        Developer pythonDeveloper = new Developer();
        pythonDeveloper.addBook("Learning Python, 5th Edition");
        pythonDeveloper.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(javaDeveloper);
        list.add(pythonDeveloper);

        Set<String> collect =
            list.stream()
                .map(Developer::getBook)                              //  Stream<Set<String>>
                .flatMap(Collection::stream)                           //  Stream<String>
                .filter(x -> !x.toLowerCase().contains("python"))   //  filter python book
                .collect(Collectors.toSet());                       //  remove duplicated

        collect.forEach(System.out::println);

    }
}


class Developer {

    private Set<String> book;

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }

    public Set<String> getBook() {
        return book;
    }
}
