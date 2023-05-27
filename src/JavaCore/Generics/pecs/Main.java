package JavaCore.Generics.pecs;

import java.util.List;

/**
 * PECS - Producer Extends Consumer Super
 * https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
 * https://habr.com/ru/post/559268/
 * https://habr.com/ru/post/207360/
 * */

public class Main {
    public static void main(String[] args) {
        someMethod1(List.of(new Class4(), new Class4()));
    }

    //EXTENDS
    public static void someMethod1 (List<? extends Class3> list) {



        /**
         * компилятор не знает что какой тип подставиться в "вопросик ?" или Class3 или Class4 или Class5
         * и при получении мы не знаем с каким типом работаем, поэтому нужно скастить явно указав с каким типом мы работаем
         * что не очень хорошо так как мы сводим на нет защиту типов
         *
         * */
        //    Class4 class4 = list.get(0); // не скомпилируеться

        /**
         *  из list можно получить обьеты только суперкласов так как наследник знает о своем родителе - extends
         *  (когда super - Родитель ничего не знает о наследнике)
         *  */
        Class2 class2 = list.get(0);



    }

    //SUPER
    public static void someMethod2 (List<? super Class3> list) {
        list.add(new Class4());
    }
}

class Class0 {}
class Class1 extends Class0 {}
class Class2 extends Class1 {}
class Class3 extends Class2 {}
class Class4 extends Class3 {}
class Class5 extends Class4 {}
class Class6 extends Class5 {}