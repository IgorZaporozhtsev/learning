package books.deepcloudlabs.part_2.exercises.ex1;

import books.deepcloudlabs.part_2.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DC2MainEx1 {
    private static final List<Animal> animals = Arrays.asList(
            new Cat(),
            new Spider(),
            new Cat("Tekir"),
            new Fish("Free Willy"),
            new Spider(),
            new Fish("Jaws")
    );


    public static void main(String[] args) {
        Predicate<Animal> isPet1 = animal -> {
            if (animal instanceof Pet) return false;
            return true;
        };

        // Take a list of wild animals  - 1
        List<Animal> wildAnimals1 = animals.stream()
                .filter(isPet1)
                .toList();


        // Take a list of wild animals  - 2

        Predicate<Animal> isPet = Pet.class::isInstance;
        Predicate<Animal> isWild = isPet.negate();

        List<Animal> wildAnimals = animals.stream()
                .filter(isWild)
                .toList();

        wildAnimals.stream()
                .map(Object::getClass)
                .map(Class::getName)
                .distinct()
                .forEach(System.out::println);
    }
}
