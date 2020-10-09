package JavaCore.Generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RawTypesGeneric {
    public static void main(String[] args) {
        SomeType someType = new SomeType();       // создали без generic
        List<String> list = Arrays.asList("value");
        someType.test(list);
    }
}

class SomeType<T>{

    public <E> void test(Collection<E> collection){
        for (E e:collection) {
            System.out.println(e);
        }
    }

    public void test(List<Integer> integerList){
        for (Integer integer:integerList) {
            System.out.println(integer);
        }
    }


}
