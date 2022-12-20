package Java8.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vaska", 5, "red");
        Cat cat2 = new Cat("Murka", 12, "green");
        Cat cat3 = new Cat("Kuzya", 3, "black");
        Cat cat4 = new Cat("Bony", 8, "blue");
        Cat cat5 = new Cat("Umka", 15, "white");
        Cat cat6 = new Cat("Mo", 3, "red");

        List<Cat> catList = new ArrayList<>();
        catList.add(cat1);
        catList.add(cat2);
        catList.add(cat3);
        catList.add(cat4);
        catList.add(cat5);
        catList.add(cat6);

        List<String> catByAge = catList.stream()
                .filter(n -> n.getAge() > 1)
                .map(n -> n.getName()) //преобразовали в строку. Можно таким способом .map(Cat::getName)
                .sorted((a,b) -> a.length() - b.length()) //(Comparator.comparingInt(String::length))
                .collect(Collectors.toCollection(ArrayList::new));

        printList(catByAge);
    }


    public static void printList(List<?> list){
        for (Object object:list) {
            System.out.println(object);
        }
    }
}
