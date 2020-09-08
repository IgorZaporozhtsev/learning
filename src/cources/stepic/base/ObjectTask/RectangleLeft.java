package cources.stepic.base.ObjectTask;


import java.util.function.DoubleUnaryOperator;

public class RectangleLeft {
    public static void main(String[] args) {

        System.out.println(integrate(x -> 1, 0, 10));
    }




    public static double integrate(DoubleUnaryOperator f, double a, double b) {

        double step = (b-a)/10000000;
        double result = 0;
        double width = a;

        for (int i = 0; i < 10000000; i++) {

         width = width + step;

            result = result + f.applyAsDouble(width);
        }

        return step * result;


    }
}
