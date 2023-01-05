package books.ModernJavaInAction.data_collection.func_approach;

import books.ModernJavaInAction.model.CaloricLevel;
import books.ModernJavaInAction.model.Dish;
import books.ModernJavaInAction.model.Type;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import static books.ModernJavaInAction.model.Menu.getMenu;
import static java.util.stream.Collectors.*;

public class Grouping {

    public static void main(String[] args) {
        List<Dish> menu = getMenu();

        /*
        how groupingBy works
        groupingBy(classifier, downstream)
        classifier - is a key
        downstream - is a value (f.e toList())
        f.e -   groupingBy(Dish::getType, toList())
                groupingBy(Dish::getType, mapping(mapper, downstream))
                groupingBy(Dish::getType, filtering(predicate, downstream))


        */
//

//how to avoid Optional
        var mostCaloricByType1 = menu.stream().collect(
                groupingBy(Dish::getType,
                        maxBy(Comparator.comparingInt(Dish::getCalories))));

        var mostCaloricByType2 = menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(
                        maxBy(
                                Comparator.comparingInt(Dish::getCalories)),
                        Optional::get)));

        var mostCaloricByType3 = menu.stream().collect(
                toMap(
                        Dish::getType,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories))));


//groupingBy second downstream parameter counting
        var typesCount = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));


        //-----many level grouping
        //---- dishesTypeByCaloriesLevel

        Map<Type, Map<CaloricLevel, List<Dish>>> dishesTypeByCaloriesLevel =
                menu.stream().collect(groupingBy(Dish::getType,
                        groupingBy(dish ->
                                {
                                    if (dish.getCalories() > 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                }
                        )));



//----collect mapping
        Map<Type, List<String>> byTypeWithLIstOfNames = menu.stream().collect(groupingBy(
                Dish::getType, mapping(Dish::getName, toList())));


//----filtering (action after grouping - filter() not always work - use filtering)

        //--- issue
        /* here Type.FISH didn't included because fulfills the conditions, but we want to se in Map as empty value

           -- actual --

           OTHER=[french fries, pizza],
           MEAT=[pork, beef]

          --- expected ---

           OTHER=[french fries, pizza],
           MEAT=[pork, beef]
           FISH = []

        */


        Map<Type, List<Dish>> byCaloriesLessThan500 = menu.stream()
                .filter(dish -> dish.getCalories() > 500)
                .collect(groupingBy(Dish::getType));


        // --- solution ---

        Map<Type, List<Dish>> byCaloriesLessThan500_2 = menu.stream()
                .collect(groupingBy(
                        Dish::getType,
                        filtering(dish -> dish.getCalories() > 500, toList())));



//----grouping by type that not exist in class, but we use condition
// action after grouping - Collect by enum even Dish class doesn't hold enum CaloricLevel
        Map<CaloricLevel, List<Dish>> collect = menu.stream().collect(groupingBy(dish ->
                {
                    if (dish.getCalories() > 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }
        ));


//----group by

        Map<Type, List<Dish>> groupByType = menu.stream().collect(groupingBy(Dish::getType, toList()));
    }

}
