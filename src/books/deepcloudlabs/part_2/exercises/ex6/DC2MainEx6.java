package books.deepcloudlabs.part_2.exercises.ex6;

import books.deepcloudlabs.part_2.domain.Animal;
import books.deepcloudlabs.part_2.domain.Cat;
import books.deepcloudlabs.part_2.domain.Fish;
import books.deepcloudlabs.part_2.domain.Spider;
import util.PrintUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DC2MainEx6 {

    public static void main(String[] args) {
        // Group the animals by their number of legs
        List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
                new Spider(), new Fish("Jaws"));

        Map<Integer, List<Animal>> groupedAnimals = animals.stream().
                collect(Collectors.groupingBy(Animal::getLegs));

        PrintUtil.printMapOfList(groupedAnimals);
    }
}
