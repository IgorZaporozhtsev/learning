package books.blog.devgenius.io.repo;

import books.blog.devgenius.io.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {

    private static final Map<Long, Customer> customers = new HashMap<>();


   static  {
        customers.put(1L, new Customer(1L, "Stephania", 0));
        customers.put(2L, new Customer(2L, "Sopfia", 2));
    }

    public static Customer getCustomer(Long customerId) {
        return customers.get(customerId);
    }

}
