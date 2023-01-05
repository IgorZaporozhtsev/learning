package books.ModernJavaInAction.behavior_parameterization.problem;

import books.ModernJavaInAction.behavior_parameterization.solution.AppleGreenColorPredicate;
import books.ModernJavaInAction.behavior_parameterization.solution.AppleHeavyWeightPredicate;
import books.ModernJavaInAction.behavior_parameterization.solution.ApplePredicate;
import books.ModernJavaInAction.behavior_parameterization.solution.AppleRedAndHeavyPredicate;
import books.ModernJavaInAction.behavior_parameterization.with_generics.Predicate;
import books.ModernJavaInAction.model.Apple;
import books.ModernJavaInAction.model.Bananas;
import books.ModernJavaInAction.model.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static books.ModernJavaInAction.model.Color.*;

public class MainApple {
    public static void main(String[] args) {
        var inventory1 = List.of(new Apple(GREEN), new Apple(RED));
        var inventory2 = List.of(new Apple(GREEN, 200), new Apple(RED, 300));
        var inventory3 = List.of(new Bananas(GREEN, 200), new Bananas(RED, 300));

        //STEP 1
        List<Apple> greenApples = filterGreenApples(inventory1);
        printApple("greenApples" , greenApples);
        //STEP 2
        List<Apple> applesByColorRed = filterApplesByColor(inventory1, RED);
        List<Apple> applesByColorGreen = filterApplesByColor(inventory1, GREEN);
        printApple("applesByColorRed", applesByColorRed);
        printApple("applesByColorGreen", applesByColorGreen);
        //STEP3
        printApple("bad filter attempt - false", filterApples(inventory2, GREEN, 130, false));
        printApple("bad filter attempt - true",  filterApples(inventory2,RED, 34, true));


        printApple("filter with green color predicate",
                filterApplesWithPredicate(inventory2, new AppleGreenColorPredicate()));
        printApple("filter with weight predicate",
                filterApplesWithPredicate(inventory2, new AppleHeavyWeightPredicate()));
        printApple("filter with red and heavy predicate",
                filterApplesWithPredicate(inventory2, new AppleRedAndHeavyPredicate()));

        //STEP 5 using lambda
        List<Apple> apples = filterApplesWithPredicate(inventory2, apple -> GREEN.equals(apple.getColor()));
        printApple("filter with green color with lambda predicate", apples);


        //STEP 6 with Generics
        var bananas = filter(inventory3, banana-> GREEN.equals(banana.getColor()));
        printApple("filter banana with lambda generics", bananas);


    }

    //STEP 1
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();

        for (Apple apple: inventory) {
            if (GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

/*
    but if we want filter RED apples?
    should we create new method, no!
    we have to use abstraction if we notice that we write same code
*/

    //STEP 2
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color){
        List<Apple> result = new ArrayList<>();

        for (Apple apple: inventory) {
            if (color.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }
/*
    DRY (Don’t Repeat Yourself)

    but in we want to add weight then we repeat ou code
    we can add color and weight process in one filter() method
    but how to we define we want filter now color or weight
    we can create flag what we want filter now - DON'T DO THAT!
*/

    //STEP 3 Bad attempt, DON'T DO THAT!
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();

        for (Apple apple: inventory) {
            if ( (flag && apple.getColor().equals(color) ||   //DON'T DO LIKE THAT!
                    !flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    //STEP 4 SOLUTION, Strategy

    public static List<Apple> filterApplesWithPredicate(List<Apple> apples, ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();

        for (Apple apple: apples) {
            if (predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;

    }


    //STEP 6 using Generics
    public static <T> List<T> filter(List<T> inventory, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T value: inventory) {
            if (predicate.test(value)){
                result.add(value);
            }
        }
        return result;

    }





    public static <T> void printApple(String metadata, List<T> inventory){
        System.out.println(metadata + " - " + Arrays.toString(inventory.toArray()) + "\n");
    }
}
