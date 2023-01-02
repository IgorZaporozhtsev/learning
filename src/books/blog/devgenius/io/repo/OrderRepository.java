package books.blog.devgenius.io.repo;

import books.blog.devgenius.io.model.Customer;
import books.blog.devgenius.io.model.Order;
import books.blog.devgenius.io.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public static final List<Product> productsOfFirstOrder = ProductRepository.findAll();
    public static final List<Product> productsOfSecondOrder = List.of(new Product(9L, "Overns", "Baby", 55));
    public static final Customer customer2 = CustomerRepository.getCustomer(2L);
    public static final Customer customer1 = CustomerRepository.getCustomer(1L);


    public static ArrayList<Order> findAll(){

        var list = new ArrayList<Order>();
        list.add(new Order(1L, "active", LocalDate.of(2022, 8, 2), LocalDate.now(), productsOfFirstOrder, customer1));
        list.add(new Order(2L, "active", LocalDate.of(2022, 3, 15), LocalDate.now(), productsOfSecondOrder, customer2));
        list.add(new Order(3L, "active", LocalDate.of(2022, 2, 4), LocalDate.now(), productsOfSecondOrder, customer2));
        list.add(new Order(4L, "active", LocalDate.of(2022, 2, 17), LocalDate.now(), productsOfSecondOrder, customer2));


        return list;

    }
}
