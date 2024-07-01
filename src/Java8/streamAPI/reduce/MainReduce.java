package Java8.streamAPI.reduce;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainReduce {
    public static void main(String[] args) {

        /* -------------------------------- EXAMPLE 0 --------------------------------------- */
        BigInteger factorial = IntStream.rangeClosed(1, 3)
            .mapToObj(BigInteger::valueOf)
            .reduce(BigInteger.ONE, BigInteger::multiply);

        //System.out.println(factorial);

        Stream<String> wordsStream = Stream.of("мама", "мыла", "раму");
        Optional<String> sentence = wordsStream.reduce((x, y) -> x + " " + y);
        //System.out.println(sentence.orElse("empty"));

        /* -------------------------------- EXAMPLE 1 --------------------------------------- */
        // T reduce(T identity, BinaryOperator<T> accumulator);

        List<Product> products = Arrays.asList(
                new Product("Phone", BigDecimal.valueOf(800)),
                new Product("Laptop", BigDecimal.valueOf(1200)),
                new Product("Headphones", BigDecimal.valueOf(50))
        );

        BigDecimal totalPrice1 = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, (accumulator, element) -> accumulator.add(element));

        //System.out.println("Total price of products: $" + totalPrice1);


        /* -------------------------------- EXAMPLE 2 --------------------------------------- */
        // Optional<T> reduce(BinaryOperator<T> accumulator);

        BigDecimal totalPrice2 = products.stream()
                .map(Product::getPrice)
                .reduce((bigDecimal, augend) -> bigDecimal.add(augend))
                .orElse(BigDecimal.ZERO);

        //System.out.println("Total price of products: $" + totalPrice2);

        BigDecimal calculateTotalPriceAccordingToDiscount = products.stream()
                .map(Product::getPrice)
                .reduce((accumulator, element) -> element.compareTo(accumulator) > 0 ? accumulator : element)
                .orElse(BigDecimal.ZERO);

        //System.out.println("TotalDiscount price of products: $" + calculateTotalPriceAccordingToDiscount);



    /* -------------------------------- EXAMPLE 3 --------------------------------------- */
    // <U> U reduce(U identity,
    //                 BiFunction<U, ? super T, U> accumulator,
    //                 BinaryOperator<U> combiner);
    //use reduce with 3 parameters when we want to combine different types

        BigDecimal higherPriceThen100_1 = products.stream()
                .map(Product::getPrice)
                .reduce(
                        BigDecimal.ZERO,
                        (BigDecimal accumulator, BigDecimal element) ->
                            element.compareTo(BigDecimal.valueOf(100)) > 0 ?  accumulator.add(element) : accumulator,
                        BigDecimal::add); //we don't need here third parameter because we map Product to price.
        //we work with (BigDecimal accumulator, BigDecimal element) parameters both BigDecimal

        System.out.println(" price of products: $" + higherPriceThen100_1);


        BigDecimal higherPriceThen100_2 = products.stream()
                .reduce(
                        BigDecimal.ZERO,
                        (BigDecimal accumulator, Product product) ->
                                product.getPrice().compareTo(BigDecimal.valueOf(100)) > 0 ?  accumulator.add(product.getPrice()) : accumulator,
                        BigDecimal::add);  //we NEED here third parameter because we should combine (BigDecimal accumulator, Product product)

        System.out.println(" price of products: $" + higherPriceThen100_2);


    }
}


class Product {
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

class Phone{

    private String name;
    private int price;

    public Phone(String name, int price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}