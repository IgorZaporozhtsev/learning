package books.deepcloudlabs.part_2.exercises.ex8;

import books.deepcloudlabs.part_2.domain.Animal;
import books.deepcloudlabs.part_2.domain.Cat;
import books.deepcloudlabs.part_2.domain.Fish;
import books.deepcloudlabs.part_2.domain.Spider;

import java.util.Arrays;
import java.util.List;


public class DC2MainEx8 {
    public static void main(String[] args) {
        // Count the number of species
        List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
                new Spider(), new Fish("Jaws"));
        animals.stream()
                .map(Animal::getClass)
                .map(Class::getSimpleName)
                .distinct()
                .forEach(System.out::println);

        //System.out.println(totalNumberOfSpecies);


        String str = "Print";

        var result = switch (str) {
            case null -> "";
            case "Print" -> printHello();
            case "Bye" -> printBye();

            default -> throw new IllegalStateException("Unexpected value: " + str);
        };
    }

    private static String printHello() {

        return "Hello";
    }

    private static String printBye() {

        return "Bye";
    }

}
