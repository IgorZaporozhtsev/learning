package Java8.functional_interface.supplier;

import java.util.function.Supplier;
import Java8.prepared_data.User;

public class Demo {
    public static void main(String[] args) {
        Supplier<User> adminSupplier = ()-> new User("34234","Tom");
        process(adminSupplier);

    }

    //1. Lazy Initialization Use a Supplier to create objects only when required, (deferred execution)
    // which can be useful in scenarios where the object initialization is resource-intensive or conditional.
    private static void process(Supplier<User> supplier){
        User user = supplier.get();
    }

    //2. Dynamic Object Creation When the creation logic of an object depends on runtime conditions,
    // you can use a Supplier to encapsulate this logic.
    //also as a factory

    Supplier<User> dynamicUserSupplier = () -> {
        if (Math.random() > 0.5) {
            return new User("1", "Tom");
        } else {
            return new User("2", "Jerry");
        }
    };
    User user = dynamicUserSupplier.get(); // Produces a User dynamically


}




