package books.ModernJavaInAction.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static books.ModernJavaInAction.model.Type.*;
import static books.ModernJavaInAction.model.Type.FISH;

public class DataGenerator {


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
    public static List<Transaction> getAllTransactions(){
        return new ArrayList<Transaction>(Arrays.asList(
                new Transaction(Currency.EUR, 200, "122"),
                new Transaction(Currency.EUR, 230, "123"),
                new Transaction(Currency.USD, 125, "124"),
                new Transaction(Currency.EUR, 435, "125"),
                new Transaction(Currency.EUR, 920, "126"),
                new Transaction(Currency.USD, 1340, "127"),
                new Transaction(Currency.EUR, 124, "128"),
                new Transaction(Currency.EUR, 434, "129"),
                new Transaction(Currency.USD, 650, "130"),
                new Transaction(Currency.EUR, 330, "131"),
                new Transaction(Currency.EUR, 95, "132")
        ));

    }
}
