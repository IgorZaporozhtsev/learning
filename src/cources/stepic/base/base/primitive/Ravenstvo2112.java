package cources.stepic.base.base.primitive;

/*Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
Допустимая погрешность – 0.0001 (1E-4)*/


public class Ravenstvo2112 {
    public static void main(String[] args) {
        System.out.println(doubleExpression(0.1, 0.2, 0.3));
    }


    public static boolean doubleExpression(double a, double b, double c) {

        double e = 0.0001;
        boolean result = Math.abs((a + b)-c) < e;

        return result;
    }
}
