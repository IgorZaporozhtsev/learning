package books.ModernJavaInAction.data_collection.func_approach;

import books.ModernJavaInAction.util.Dish;
import books.ModernJavaInAction.util.Type;


import java.util.*;

import static books.ModernJavaInAction.util.Type.*;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, MEAT),
                new Dish("beef", false, 700, MEAT),
                new Dish("chicken", false, 400, MEAT),
                new Dish("french fries", true, 530, OTHER),
                new Dish("rice", true, 350, OTHER),
                new Dish("season fruit", true, 120, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("salmon", false, 450, FISH) );

        //----
        //----
        //----
        //----total different ways

        //----using reducing
        Integer totalCaloriesWithReducing = menu.stream().
                collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(totalCaloriesWithReducing);

        Optional<Dish> mostCalorieDish =
                menu.stream().collect(reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

        //----join String
        String joinByName = menu.stream().map(Dish::getName).collect(joining(","));

        //-----summarising all fields, statistic
        IntSummaryStatistics menuStatistic = menu.stream().collect(summarizingInt(Dish::getCalories));
        int max = menuStatistic.getMax();
        int min = menuStatistic.getMin();
        double average = menuStatistic.getAverage();

        //-----average int
        Double averageCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        //-----summing
        Integer totalCalories1 = menu.stream().collect(summingInt(Dish::getCalories));
        Integer totalCalories2 = menu.stream().mapToInt(Dish::getCalories).sum();

        //-----min amn max value
        Comparator<Dish> dishComparator = (d1, d2) -> d1.getCalories() - d2.getCalories();
        Comparator<Dish> dishComparatorMethodRef = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloricDish = menu.stream().collect(maxBy(dishComparatorMethodRef));

        //----- count dishes in menu
        long howManyDishes = menu.stream().collect(counting());
    }
}
