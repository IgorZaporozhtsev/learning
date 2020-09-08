package Java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEx2 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);


        System.out.println(sumAll(numbers));
        System.out.println(sumAllEven(numbers));

        System.out.println("Java 8 Lambda");
        System.out.println(sumAll(numbers, n -> true));
        System.out.println(sumAll(numbers, n -> n % 2 == 0));
        System.out.println(sumAll(numbers, n -> n > 3));

    }


    //------------------------Метод старого решения----------------------------------------------

    //------------------------Сумма чисел в масиве----------------------------------------------

    public static int sumAll(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    //------------------------Сумма только четных чисел----------------------------------------------

    public static int sumAllEven(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                total += number;
            }
        }
        return total;
    }


    //------------------------С использованием функционального интоерфейса----------------------------------------------

    public static int sumAll(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int number : numbers) {
            if (p.test(number)) {
                total += number;
            }
        }
        return total;
    }

}
