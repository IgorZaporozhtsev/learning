package Java8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaExample {
    public static void main(String[] args) {
        Predicate<Integer> predicate = n -> n > 1;
        System.out.println(predicate.test(4));

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.stream()
               .filter(n -> n.contains("o"))
               .forEach(System.out::println);


        //list
        //   .forEach(System.out::println);


        Arrays.asList(1,2,3)
            .stream()
            .forEach(System.out::println);

        Stream.of(1,2,3)
            .forEach(System.out::println);

        int[] array = {10, 20, 59};
        IntStream stream = Arrays.stream(array);

        System.out.println("-------Вернуть количество вхождений объекта «a1»-------------------------------");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        System.out.println(
            collection
                .stream()
                .filter(n -> n.equals("a1"))
                .count()
        );

        System.out.println("-------Вернуть первый элемент коллекции или 0, если коллекция пуста-------------");

        System.out.println(
                collection
                        .stream()
                        .findFirst()
                        .orElse("0")
        );

        System.out.println("-------Вернуть последний элемент коллекции или «empty», если коллекция пуста----");

        System.out.println(
                collection
                        .stream()
                        .skip(collection.size() - 1)
                        .findAny()
                        .orElse("empty")
        );

        System.out.println("-------Найти элемент в коллекции равный «a3» или кинуть ошибку-------------------");

        System.out.println(
                collection
                        .stream()
                        .filter(n -> n.equals("a3"))
                        .findFirst()
                        .get()
        );

        System.out.println("-------Вернуть третий элемент коллекции по порядку-------------------------------");

        System.out.println(
                collection
                        .stream()
                        .skip(2)
                        .findFirst()
                        .get()
        );

        System.out.println("-------Вернуть два элемента начиная со второго-----------------------------------");

        System.out.println(
                collection
                        .stream()
                        .skip(1)
                        .limit(2)
        );

        System.out.println("-------Выбрать все элементы по шаблону-------------------------------------------");

        System.out.println(
                collection
                        .stream()
                        .filter((s) -> s.contains("1"))
                        .collect(Collectors.toList())
        );




    }
}
