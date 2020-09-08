package cources.stepic.base.tutorial.Generics;

import java.util.ArrayList;

public class GenericsSuper {
    public static void main(String[] args) {

       /*
      здесь храняться ? предок Integer

       В этом примере нижняя граница
       в этом List лежит что угодно что Integer или его предок (Integer -> Number -> Object)

       */

        ArrayList<? super Integer> ref = new ArrayList<>();
        ref.add(1); // можно хранить что Integer и выше

        /*Тут хранилище непонятно чего. Ты вытаскиваешь (.get) а вдруг там Number или Object */
        //Integer ref2 = ref.get(0);// ОШИБКА

    }
}
