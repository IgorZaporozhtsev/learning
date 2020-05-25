package cources.stepic.base.base.Tsikli;

import java.math.BigInteger;

//FACTORIAL

public class Factorial248 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

//    public static BigInteger factorial(int value) {
//        BigInteger ret = BigInteger.ONE;
//
//        for (int i = 1; i <= value; ++i) {
//            ret = ret.multiply(BigInteger.valueOf(i));
//        }
//        return ret;
//    }

    public static BigInteger factorial(int value) {

        if (value == 1) return BigInteger.valueOf(1);
        if (value == 2) return BigInteger.valueOf(2);

       BigInteger count = factorial(value - 1).multiply(BigInteger.valueOf(value));
        return count;

    }

}
