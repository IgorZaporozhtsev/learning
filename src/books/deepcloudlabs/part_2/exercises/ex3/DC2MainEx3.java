package books.deepcloudlabs.part_2.exercises.ex3;

import books.deepcloudlabs.part_2.domain.Animal;
import books.deepcloudlabs.part_2.domain.Cat;
import books.deepcloudlabs.part_2.domain.Fish;
import books.deepcloudlabs.part_2.domain.Spider;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DC2MainEx3 {

    public static void main(String[] args) {
        // Find the animal with the highest number of legs
        List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
                new Spider(), new Fish("Jaws"));

        Consumer<? super Animal> printAnimal = System.out::println;

        animals.stream()
                .max(Comparator.comparingInt(Animal::getLegs))
                .ifPresent(printAnimal);
    }
}
