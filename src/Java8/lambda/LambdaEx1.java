package Java8.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaEx1 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.print("Simple example\n");
        for (int number : numbers) {
            System.out.print(number);
        }
        System.out.println("\nLambda example");
        numbers.forEach((Integer number) -> System.out.print(number)); //параметры выражения -> тело выражения
        System.out.println();
        numbers.forEach(System.out::print);
    }
}
