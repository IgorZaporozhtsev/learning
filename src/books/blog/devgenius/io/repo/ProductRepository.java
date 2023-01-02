package books.blog.devgenius.io.repo;

import books.blog.devgenius.io.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public static List<Product> findAll() {
        var list = new ArrayList<Product>();

//        list.add(new Product(1L, "Horstman", "books", 123));
//        list.add(new Product(2L, "Piterson", "magazine", 32));
//        list.add(new Product(3L, "Jakob", "books", 43));
//        list.add(new Product(4L, "Krakson", "baby", 45));
        list.add(new Product(5L, "Car", "toys", 50));
        list.add(new Product(6L, "Dolson", "books", 40));
//        list.add(new Product(7L, "Hemolton", "books", 55));
//        list.add(new Product(8L, "Jonson", "baby", 55));
        list.add(new Product(9L, "Overns", "books", 50));

        return list;
    }
}
