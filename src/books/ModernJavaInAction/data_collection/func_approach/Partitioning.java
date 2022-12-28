package books.ModernJavaInAction.data_collection.func_approach;

import books.ModernJavaInAction.util.Dish;


import java.util.List;
import java.util.stream.Collectors;

import static books.ModernJavaInAction.util.Menu.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;


public class Partitioning {
    public static void main(String[] args) {
        List<Dish> menu = getMenu();



//vegetarian
    var byVegetarian = menu.stream().
            collect(partitioningBy(Dish::isVegetarian));

//vegetarianDishesByType
    var vegetarianDishesByType = menu.stream()
        .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

    printMapOfMap(vegetarianDishesByType);


    }


}
