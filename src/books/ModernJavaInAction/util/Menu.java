package books.ModernJavaInAction.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static books.ModernJavaInAction.util.Type.*;
import static books.ModernJavaInAction.util.Type.FISH;

public class Menu {


    public static List<Dish> getMenu() {
        return Arrays.asList(
                new Dish("pork", false, 800, MEAT),
                new Dish("beef", false, 700, MEAT),
                new Dish("chicken", false, 400, MEAT),
                new Dish("french fries", true, 530, OTHER),
                new Dish("rice", true, 350, OTHER),
                new Dish("season fruit", true, 120, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("salmon", false, 450, FISH));
    }


    public static <K,V> void print(Map<K,V> map){
        map.forEach((k,v) -> System.out.println(k + " " + v));
    }

    public static  <T, R> void printMapOfList(Map<T, List<R>> map){

        for ( Map.Entry<T, List<R>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(dish-> System.out.println("     "+dish));

        }
    }

    public static  <T, R, K> void printMapOfMap(Map<T, Map<R, List<K>>> map){
        for ( Map.Entry<T, Map<R, List<K>>> entry :map.entrySet()) {
            System.out.println(entry.getKey() + ":");


            for (Map.Entry<R, List<K>> value: entry.getValue().entrySet()) {
                System.out.println("     "  + value.getKey() + ":");
                value.getValue().forEach(dish -> System.out.println("           "+dish));
            }

        }
    }
}
