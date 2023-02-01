package books.deepcloudlabs.part_2.exercises.ex2;

import books.deepcloudlabs.part_2.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DC2MainEx2 {

    private static final List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"),
            new Fish("Free Willy"), new Spider(), new Fish("Jaws"));


    public static void main(String[] args) {
        // Take a list of pets

        Predicate<Animal> isPet = Pet.class::isInstance;

        List<Animal> pets = animals.stream()
                .filter(isPet)
                .toList();

        pets.stream()
                .map(Object::getClass)
                .map(Class::getName)
                .distinct()
                .forEach(System.out::println);
    }
}
