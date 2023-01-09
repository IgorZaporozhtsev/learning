package books.blog.devgenius.io;

import books.ModernJavaInAction.model.Menu;
import books.blog.devgenius.io.model.Order;
import books.blog.devgenius.io.model.Product;
import books.blog.devgenius.io.repo.OrderRepository;
import books.blog.devgenius.io.repo.ProductRepository;
import util.PrintStream;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.summingInt;

public class Main {


    public static List<Product> products = ProductRepository.findAll();
    public static List<Order> orders = OrderRepository.findAll();

    public static void main(String[] args) {

        //Exercise 1 - Obtain a list of products belongs to category “Books” with price > 100
        List<Product> booksOver100 = products.stream()
                .filter(product -> product.category.equalsIgnoreCase("books"))
                .filter(product -> product.price > 100)
                .toList();


        //Exercise 2 - Obtain a list of order with products belong to category “Baby”
        List<Order> result = orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.category.equalsIgnoreCase("baby")))
                .toList();

        //Exercise 3 - Obtain a list of product with category = “Toys” and then apply 10% discount
        List<Product> toysWithDiscount10 = products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("toys"))
                .map(product -> product.withPrice(product.getPrice() * 0.9))
                .toList();

        //Exercise 4 - Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
        List<Product> twoTierMoth = orders.stream()
                .filter(order -> order.customer.tier == 2)
                .filter(order ->
                        order.deliveryDate.isBefore(LocalDate.of(2021, 2, 1)))
                .filter(order ->
                        order.deliveryDate.isAfter(LocalDate.of(2021, 4, 1)))
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .distinct()
                .toList();

        //Exercise 5 - Get the cheapest products of “Books” category
        Optional<Product> cheapestBook = products.stream()
                .filter(product -> !product.getCategory().equalsIgnoreCase("book"))
                .min(Comparator.comparing(Product::getCategory));


        //Exercise 6 - Get the 3 most recent placed order
        List<Order> recentOrder = orders.stream()
                .sorted(Comparator.comparing(order -> order.orderDate))
                .limit(3)
                .toList();

        //Exercise 7 - Get a list of orders which were ordered on 15-Mar-2021,
        // log the order records to the console and then return its product list
        List<Product> productByDate = orders.stream()
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2022, 3, 15)))
                //.peek(System.out::println)
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .distinct()
                .toList();

        //Exercise 8 - Calculate total lump sum of all orders placed in Feb 2021
        Double totalDebOrders = orders.stream()
                .filter(order -> order.getOrderDate().getMonth().equals(Month.FEBRUARY))
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .mapToDouble(Product::getPrice)
                .sum();

        //Exercise 9 — Calculate order average payment placed on 14-Mar-2021
        Double average = orders.stream()
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 14)))
                .map(Order::getProducts)
                .flatMap(Collection::stream)
                .mapToDouble(Product::getPrice)
                .average()
                .getAsDouble();

        //Exercise 10 — Obtain a collection of statistic figures (i.e. sum, average, max, min, count)
        // for all products of category “Books”
        DoubleSummaryStatistics stat1 = products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("book"))
                .collect(Collectors.summarizingDouble(Product::getPrice));


        DoubleSummaryStatistics statistics = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();


        //Exercise 11 — Obtain a data map with order id and order’s product count
        var orderProductsCount1 = orders.stream()
                        .collect(groupingBy(
                                Order::getId, summingInt(order-> order.getProducts().size())));


        var orderProductsCount2 = orders.stream()
                        .collect(toMap(Order::getId, order -> order.getProducts().size()));


        //Exercise 12 — Produce a data map with order records grouped by customer
        var byCustomer= orders.stream()
                .collect(groupingBy(Order::getCustomer));


        //Exercise 13 — Produce a data map with order record and product total sum

        var totalSumOfOrders = orders.stream()
                .collect(toMap( Function.identity(), order -> order.getProducts().stream()
                                        .mapToDouble(Product::getPrice).sum()
                        )
                );

        //Exercise 14 — Obtain a data map with list of product name by category
        Map<String, List<String>> productByCategory = products.stream()
                .collect(groupingBy(
                        Product::getCategory, mapping(Product::getName, toList())));


        //Exercise 15 Get the most expensive product by category
        Map<String, Optional<Product>> expensiveProductByCategory = products.stream()
                .collect(groupingBy(
                        Product::getCategory,
                        mapping(
                                Function.identity(),
                                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)))));

        Map<String, Product> expensiveProductByCategory2 = products.stream()
                .collect(groupingBy(
                        Product::getCategory,
                        collectingAndThen(
                                maxBy(Comparator.comparingDouble(Product::getPrice)),
                                Optional::get)));



                        //System.out.println(Arrays.toString(productByDate.toArray()));
    }



}

