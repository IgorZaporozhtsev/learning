package books.ModernJavaInAction.behavior_paprameterization.problem;

import books.ModernJavaInAction.util.Apple;
import books.ModernJavaInAction.util.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static books.ModernJavaInAction.util.Color.*;

public class MainApple {
    public static void main(String[] args) {
        var inventory1 = List.of(new Apple(GREEN), new Apple(RED));
        var inventory2 = List.of(new Apple(GREEN, 300), new Apple(RED, 200));

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

    public static void printApple(String metadata, List<Apple> apples){
        System.out.println(metadata + " - " + Arrays.toString(apples.toArray()));
    }
}
