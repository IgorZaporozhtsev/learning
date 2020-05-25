package cources.stepic.base.tutorial.Generics;

import java.util.ArrayList;

public class GenericsExtends {
    public static void main(String[] args) {

       /*
      здесь храняться ? наследники Integer

       В этом примере верхняя граница
       компилятор говорит что я не знаю какой тип ты добавишь
       поэтому не разрешает добавлять
       считывать разрешает

       */

        ArrayList<? extends Integer> ref = new ArrayList<>();
         /*сохранять (добавлять) запрещает.
        Ты не сказал хранилище это чего <? ....>, а сохраняешь Integer вдруг это не Integer, a String
        в <? ....> непонятно что */

        //ref.add(1); // ОШИБКА


        /*компилятор приводит к Integer не зная точно что за наследник*/
        Integer ref2 = ref.get(0);

    }
}
