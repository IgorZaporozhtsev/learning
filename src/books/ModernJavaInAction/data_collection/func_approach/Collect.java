package books.ModernJavaInAction.data_collection.func_approach;

import books.ModernJavaInAction.util.Dish;


import java.util.*;

import static books.ModernJavaInAction.util.Menu.getMenu;

import static java.util.stream.Collectors.*;

public class Collect {
    public static void main(String[] args) {
        List<Dish> menu = getMenu();

        //----total different ways
        int totalCalories4 = menu.stream().mapToInt(Dish::getCalories).sum();
        int totalCalories5 = menu.stream().map(Dish::getCalories).reduce(Integer::sum)
                .orElse(0);

        //----using reducing
        Integer totalCalories3 = menu.stream().
                collect(reducing(0, Dish::getCalories, (i, j) -> i + j));

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
