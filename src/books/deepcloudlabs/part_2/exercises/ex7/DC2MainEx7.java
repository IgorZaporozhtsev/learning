package books.deepcloudlabs.part_2.exercises.ex7;


import books.deepcloudlabs.part_2.domain.Animal;
import books.deepcloudlabs.part_2.domain.Cat;
import books.deepcloudlabs.part_2.domain.Fish;
import books.deepcloudlabs.part_2.domain.Spider;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DC2MainEx7 {

    public static void main(String[] args) {
        // Count the number of animals in each species
        List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
                new Spider(), new Fish("Jaws"));

        Map<Class<?>, Long> groupedAnimals = animals.stream()
                .collect(Collectors.groupingBy(Animal::getClass, Collectors.counting()));

        groupedAnimals.forEach((k, v) -> System.out.println(k + " : " + v));

    }
}
