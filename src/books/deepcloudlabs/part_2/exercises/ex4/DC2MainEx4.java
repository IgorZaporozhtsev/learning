package books.deepcloudlabs.part_2.exercises.ex4;

import books.deepcloudlabs.part_2.domain.Animal;
import books.deepcloudlabs.part_2.domain.Cat;
import books.deepcloudlabs.part_2.domain.Fish;
import books.deepcloudlabs.part_2.domain.Spider;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;


public class DC2MainEx4 {
    private static final Random random = new SecureRandom();
    private static final Supplier<Animal> spiderCreator = Spider::new;
    private static final Supplier<Animal> catCreator = Cat::new;
    private static final Supplier<Animal> fishCreator = () -> new Fish("Çakıl");
    private static final List<Supplier<Animal>> suppliers = Arrays.asList(spiderCreator, catCreator, fishCreator);

    public static void main(String[] args) {

        // Take a list of 100 random animals
        final List<Animal> randomAnimals =
                IntStream.generate(() -> random.nextInt(suppliers.size()))
                        .mapToObj(suppliers::get)
                        .peek(System.out::println)
                        .map(Supplier::get)
                        .limit(100)
                        .toList();
        randomAnimals.forEach(System.out::println);

    }
}
