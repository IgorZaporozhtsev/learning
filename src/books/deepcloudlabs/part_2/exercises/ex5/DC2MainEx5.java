package books.deepcloudlabs.part_2.exercises.ex5;

import books.deepcloudlabs.part_2.domain.Animal;
import books.deepcloudlabs.part_2.domain.Cat;
import books.deepcloudlabs.part_2.domain.Fish;
import books.deepcloudlabs.part_2.domain.Spider;

import java.util.Arrays;
import java.util.List;

public class DC2MainEx5 {
    public static void main(String[] args) {
        // Find the total number of legs
        List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
                new Spider(), new Fish("Jaws"));
        long totalNumOfLegs = animals.stream()
                .mapToLong(Animal::getLegs)
                .sum();

        System.out.println(totalNumOfLegs);
    }

}
