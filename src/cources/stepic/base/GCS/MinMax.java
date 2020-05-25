package cources.stepic.base.GCS;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinMax {
    public static void main(String[] args) {
    /*    Напишите метод, находящий в стриме минимальный и максимальный элементы
     в соответствии порядком, заданным Comparator'ом.

        Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:

        minMaxConsumer.accept(min, max);
        Если стрим не содержит элементов, то вызовите
        minMaxConsumer.accept(null, null);*/

        //коллекция
        // свой компаратор
        //BiConsumer


    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {



       List <T> list = stream.collect(Collectors.toList());

        if (list.isEmpty()){
            minMaxConsumer.accept(null, null );
        }  else {
            minMaxConsumer.accept(list.stream().min(order).get(), list.stream().max(order).get());
        }
               //. проверить на содержание в стриме
               //. max()
               //.
    }
}
