package books.ModernJavaInAction.data_collection.func_approach;

import books.ModernJavaInAction.util.Dish;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static books.ModernJavaInAction.util.Menu.*;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;


public class Partitioning {
    public static void main(String[] args) {
        List<Dish> menu = getMenu();

 /*
        how groupingBy works
        partitioningBy(predicate, downstream)
        predicate - is a key
        downstream - is a value (f.e toList())
        f.e -   partitioningBy(Dish::isVegetarian, toList())
                partitioningBy(Dish::getType, groupingBy(Dish::getType))
        */

//vegetarian
    var byVegetarian = menu.stream().
            collect(partitioningBy(Dish::isVegetarian));

//vegetarianDishesByType
    var vegetarianDishesByType = menu.stream()
        .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));


//mostCaloricPartitionedByVegetarian

        var mostCaloricPartitionedByVegetarian = menu.stream()
            .collect(partitioningBy(Dish::isVegetarian,
                            collectingAndThen(
                                    maxBy(comparingInt(Dish::getCalories)),Optional::get)));


        print(mostCaloricPartitionedByVegetarian);
    }


}
