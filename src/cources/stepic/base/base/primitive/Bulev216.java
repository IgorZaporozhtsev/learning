package cources.stepic.base.base.primitive;

/*Реализуйте метод, возвращающий true, если среди четырех его аргументов ровно два истинны (любые).
        Во всех остальных случаях метод должен возвращать false.*/

public class Bulev216 {
    public static void main(String[] args) {

        System.out.println(booleanExpression(false, true, false, true));
        System.out.println(booleanExpression(true, false, false, true));
        System.out.println(booleanExpression(true, false, true, false));
        System.out.println(booleanExpression(false, false, true, true));
        System.out.println();

    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        // первый вариант комбинаций (false(a) ^ true(b) & false(c) ^ true(d)) результат (true & true)
        // второй вариант комбинаций (false(a) ^ false(b) & true(c) ^ true(d)) результат (false & false) - должен быть true
        //значит нужно для второй комбинации подобрать вариант в ктором будет true - (a ^ c) & (b ^ d)
        // в итоге ((a ^ b) и (c ^ d)) или ((a ^ c) и (b ^ d));


        return ((a ^ b) & (c ^ d)) | ((a ^ c) & (b ^ d));



    }

}
