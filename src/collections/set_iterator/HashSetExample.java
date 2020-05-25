package collections.set_iterator;

import java.lang.reflect.Field;
import java.util.*;

public class HashSetExample {
    public static void main(String[] args) throws Exception {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9); //capacity = 10
        arrayList.add(10);//capacity = 15
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);//capacity = 22

        System.out.println("capacity ArrayList = " + findCapacity((ArrayList<Integer>) arrayList));

        //пока итератор находит следущее значение hasNext
        //мы берем следущее значение и выводим на экран
        System.out.println("Через Итератор");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }


        System.out.println("\n Через цикл for each");
        //каждое значение set_iterator по очереди записываеться
        //в переменную abc и выводиться в консоль
        for (String abc: set) {
            System.out.print(abc);
        }

    }


    static int findCapacity(ArrayList<Integer> al) throws Exception {
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        return ((Object[]) field.get(al)).length;
    }


}
