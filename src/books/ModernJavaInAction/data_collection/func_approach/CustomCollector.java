package books.ModernJavaInAction.data_collection.func_approach;

import books.ModernJavaInAction.util.Dish;
import books.ModernJavaInAction.util.Menu;
import cources.stepic.base.tutorial.Coll;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static books.ModernJavaInAction.util.Menu.getMenu;

public class CustomCollector {
    public static void main(String[] args) {
        List<Dish> menu = getMenu();

        List<Dish> dishes = menu.stream().collect(new ToListCollector<>());
        System.out.println(dishes.toString());

    }


}

class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    //create new container for result
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    //add item to container for result
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return (list, item)-> list.add(item);
    }

    //join multiple containers for result
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    //apply to container final transformation
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    //
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(
                EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}