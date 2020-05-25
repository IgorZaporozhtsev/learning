package Java8.functional_interface;

import java.util.Scanner;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        //Comparator метод compare() сравнивание обьектов для сортировки

        //Predicate метод test() проверка условия правда или ложь
        //принимает значение какого тто типа выдает boolean значение true/false
        Predicate<Integer> isZero = value -> value == 0;
        System.out.println(isZero.test(4));
        System.out.println(isZero.test(0));

        //Consumer метод accept() действие над обьектом Т и ничего не возвращает
        //Consumer принимает какое-то значение но ничего не возвращает
        Consumer<String> printer = string -> System.out.println(string);
        printer.accept("Hello World");

        //Function метод apply() перехот от обьекта типа Т к обьекту типа Р
        Function<Integer, Double> converter = value -> Double.valueOf(value);
        System.out.println(converter.apply(1));

        //Supplier метод get() не принимает аргументов но возвращает обьект типа Т
        // не принимает ничего в качестве параметра а просто возвращает какое то значение
        Supplier<String> text = () ->{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter text...");
            return scanner.nextLine();
        };

        System.out.println(text.get());

        //UnaryOperator метод apply() выполняет унарные операция над обьектом типа Т
        UnaryOperator<Double> sqrt = value -> Math.sqrt(value);
        System.out.println(sqrt.apply(4.0));

        //BinaryOperator метод apply() выполняет бинарные операция над обьектом типа Т
        BinaryOperator<Double> pow = (value1, value2) -> Math.pow(value1, value2);
        System.out.println(pow.apply(2.0,5.0));



    }
}
